package com.baidu.android.imsdk.db;

import android.content.Context;
import android.database.Cursor;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.group.GroupInfo;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class DBGroupTableManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String COLUMN_TABLE_NAME = "name";
    public static final String KEY = "grouptable";
    public static final String SYSTEM_TABLE = "sqlite_master";
    public static final String TAG = "DBGroupTableManager";
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, Integer> activeState;
    public ArrayList<String> exisGroupTable;
    public boolean isActivieInit;
    public boolean isGroupExistInit;

    public DBGroupTableManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isGroupExistInit = false;
        this.isActivieInit = false;
        this.exisGroupTable = new ArrayList<>();
        this.activeState = new HashMap<>();
    }

    private synchronized void initGroupActiveState(DBOperation dBOperation) {
        ArrayList query;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, dBOperation) == null) {
            synchronized (this) {
                if (this.isActivieInit) {
                    return;
                }
                if (dBOperation != null && (query = dBOperation.query(new IResultParse<GroupInfo>(this) { // from class: com.baidu.android.imsdk.db.DBGroupTableManager.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DBGroupTableManager this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.baidu.android.imsdk.db.IResultParse
                    public GroupInfo onParse(Cursor cursor) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, cursor)) == null) {
                            String string = cursor.getString(cursor.getColumnIndex("group_id"));
                            int i2 = cursor.getInt(cursor.getColumnIndex(DBTableDefine.GroupInfoColumns.COLUMN_ACTIVE_STATE));
                            GroupInfo groupInfo = new GroupInfo(string);
                            groupInfo.setState(i2);
                            return groupInfo;
                        }
                        return (GroupInfo) invokeL.objValue;
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
        }
    }

    private synchronized void initGroupTableExist(DBOperation dBOperation) {
        ArrayList query;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, dBOperation) == null) {
            synchronized (this) {
                if (this.isGroupExistInit) {
                    return;
                }
                if (dBOperation != null && (query = dBOperation.query(new IResultParse<String>(this) { // from class: com.baidu.android.imsdk.db.DBGroupTableManager.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DBGroupTableManager this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.android.imsdk.db.IResultParse
                    public String onParse(Cursor cursor) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cursor)) == null) {
                            String string = cursor.getString(cursor.getColumnIndex("name"));
                            LogUtils.d(DBGroupTableManager.TAG, string);
                            return string;
                        }
                        return (String) invokeL.objValue;
                    }
                }, SYSTEM_TABLE, new String[]{"name"}, "type = 'table' and name like 'groupmessage%'", null, null, null, null, null)) != null) {
                    this.exisGroupTable.addAll(query);
                    this.isGroupExistInit = true;
                }
            }
        }
    }

    public void activeGroup(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.activeState.put(str, 1);
        }
    }

    public void addGroupTable(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.exisGroupTable.addAll(arrayList);
        }
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.exisGroupTable.clear();
            this.activeState.clear();
        }
    }

    public void deactiveGroup(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.activeState.remove(str);
        }
    }

    public void init(DBOperation dBOperation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dBOperation) == null) {
            initGroupActiveState(dBOperation);
            initGroupTableExist(dBOperation);
        }
    }

    public boolean isActive(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, context, str)) == null) {
            if (!this.isActivieInit) {
                initGroupActiveState(DBOperationFactory.getNewDb(context));
            }
            return this.activeState.containsKey(str) && this.activeState.get(str).intValue() == 1;
        }
        return invokeLL.booleanValue;
    }

    public boolean isExistGroupTable(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, context, str)) == null) {
            if (!this.isGroupExistInit) {
                initGroupTableExist(DBOperationFactory.getNewDb(context));
            }
            return this.exisGroupTable.contains(DBTableDefine.getGroupMessageTableName(str));
        }
        return invokeLL.booleanValue;
    }

    public void quitGroupTable(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.exisGroupTable.remove(str);
        }
    }

    public void addGroupTable(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || this.exisGroupTable.contains(str)) {
            return;
        }
        this.exisGroupTable.add(str);
    }
}
