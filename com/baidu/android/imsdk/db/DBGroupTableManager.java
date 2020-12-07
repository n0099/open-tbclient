package com.baidu.android.imsdk.db;

import android.content.Context;
import android.database.Cursor;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.group.GroupInfo;
import com.baidu.android.imsdk.utils.LogUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class DBGroupTableManager {
    public static final String COLUMN_TABLE_NAME = "name";
    public static final String KEY = "grouptable";
    public static final String SYSTEM_TABLE = "sqlite_master";
    public static final String TAG = "DBGroupTableManager";
    private boolean isGroupExistInit = false;
    private boolean isActivieInit = false;
    private ArrayList<String> exisGroupTable = new ArrayList<>();
    private HashMap<String, Integer> activeState = new HashMap<>();

    public void init(DBOperation dBOperation) {
        initGroupActiveState(dBOperation);
        initGroupTableExist(dBOperation);
    }

    private synchronized void initGroupActiveState(DBOperation dBOperation) {
        ArrayList query;
        if (!this.isActivieInit && dBOperation != null && (query = dBOperation.query(new IResultParse<GroupInfo>() { // from class: com.baidu.android.imsdk.db.DBGroupTableManager.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.android.imsdk.db.IResultParse
            public GroupInfo onParse(Cursor cursor) {
                String string = cursor.getString(cursor.getColumnIndex("group_id"));
                int i = cursor.getInt(cursor.getColumnIndex(DBTableDefine.GroupInfoColumns.COLUMN_ACTIVE_STATE));
                GroupInfo groupInfo = new GroupInfo(string);
                groupInfo.setState(i);
                return groupInfo;
            }
        }, "groupinfo", new String[]{"group_id", DBTableDefine.GroupInfoColumns.COLUMN_ACTIVE_STATE}, null, null, null, null, null, null)) != null) {
            Iterator it = query.iterator();
            while (it.hasNext()) {
                GroupInfo groupInfo = (GroupInfo) it.next();
                this.activeState.put(groupInfo.getGroupId(), Integer.valueOf(groupInfo.getActiveState()));
            }
            this.isActivieInit = true;
        }
    }

    private synchronized void initGroupTableExist(DBOperation dBOperation) {
        ArrayList query;
        if (!this.isGroupExistInit && dBOperation != null && (query = dBOperation.query(new IResultParse<String>() { // from class: com.baidu.android.imsdk.db.DBGroupTableManager.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.android.imsdk.db.IResultParse
            public String onParse(Cursor cursor) {
                String string = cursor.getString(cursor.getColumnIndex("name"));
                LogUtils.d(DBGroupTableManager.TAG, string);
                return string;
            }
        }, SYSTEM_TABLE, new String[]{"name"}, "type = 'table' and name like 'groupmessage%'", null, null, null, null, null)) != null) {
            this.exisGroupTable.addAll(query);
            this.isGroupExistInit = true;
        }
    }

    public void addGroupTable(ArrayList<String> arrayList) {
        this.exisGroupTable.addAll(arrayList);
    }

    public void addGroupTable(String str) {
        if (!this.exisGroupTable.contains(str)) {
            this.exisGroupTable.add(str);
        }
    }

    public void quitGroupTable(String str) {
        this.exisGroupTable.remove(str);
    }

    public boolean isExistGroupTable(Context context, String str) {
        if (!this.isGroupExistInit) {
            initGroupTableExist(DBOperationFactory.getNewDb(context));
        }
        if (!this.exisGroupTable.contains(DBTableDefine.getGroupMessageTableName(str))) {
            return false;
        }
        return true;
    }

    public void activeGroup(String str) {
        this.activeState.put(str, 1);
    }

    public void deactiveGroup(String str) {
        this.activeState.remove(str);
    }

    public boolean isActive(Context context, String str) {
        if (!this.isActivieInit) {
            initGroupActiveState(DBOperationFactory.getNewDb(context));
        }
        if (this.activeState.containsKey(str) && this.activeState.get(str).intValue() == 1) {
            return true;
        }
        return false;
    }

    public void clear() {
        this.exisGroupTable.clear();
        this.activeState.clear();
    }
}
