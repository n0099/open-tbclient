package com.baidu.android.imsdk.chatuser.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.util.LongSparseArray;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.account.IGetUidByUkListener;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatuser.ChatUser;
import com.baidu.android.imsdk.chatuser.ChatUserManagerImpl;
import com.baidu.android.imsdk.chatuser.IGetUserIdentityListener;
import com.baidu.android.imsdk.chatuser.IpInfo;
import com.baidu.android.imsdk.db.DBBase;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.shield.IGetUserShieldListener;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class ChatUserDBManager extends DBBase {
    private static final String TAG = ChatUserDBManager.class.getSimpleName();
    private static ChatUserDBManager mInstance = null;

    private ChatUserDBManager(Context context) {
        setContext(context);
    }

    public static ChatUserDBManager getInstance(Context context) {
        if (mInstance == null) {
            synchronized (ChatUserDBManager.class) {
                if (mInstance == null) {
                    mInstance = new ChatUserDBManager(context);
                }
            }
        }
        return mInstance;
    }

    public int updateUser(ArrayList<ChatUser> arrayList) {
        int i = 0;
        synchronized (mSyncLock) {
            if (arrayList == null) {
                LogUtils.i(TAG, "update users with null!");
                i = -1;
            } else if (arrayList.size() != 0) {
                ArrayList arrayList2 = new ArrayList(arrayList.size());
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("username", arrayList.get(i2).getUserName());
                    contentValues.put(TableDefine.UserInfoColumns.COLUMN_HEAD_URL, arrayList.get(i2).getIconUrl());
                    contentValues.put(TableDefine.UserInfoColumns.COLUMN_TINY_URL, arrayList.get(i2).getTinyUrl());
                    arrayList2.add(i2, new DBBase.UpdateArgs("uid = ? ", new String[]{String.valueOf(arrayList.get(i2).getUk())}, contentValues));
                }
                i = updateBatch(TableDefine.DB_TABLE_USERINFO, arrayList2);
            }
        }
        return i;
    }

    public long updateUser(ChatUser chatUser) {
        long add;
        if (chatUser == null) {
            return 0L;
        }
        synchronized (mSyncLock) {
            add = add(TableDefine.DB_TABLE_USERINFO, new String[]{"uid"}, "uid = ? ", new String[]{String.valueOf(chatUser.getUk())}, constructChatUserContentValues(chatUser));
        }
        return add;
    }

    public long updateUserByBduid(ChatUser chatUser) {
        long add;
        if (chatUser == null) {
            return 0L;
        }
        synchronized (mSyncLock) {
            add = add(TableDefine.DB_TABLE_USERINFO, new String[]{"buid"}, "buid = ? ", new String[]{String.valueOf(chatUser.getBuid())}, constructChatUserContentValues(chatUser));
        }
        return add;
    }

    public ContentValues constructChatUserContentValues(ChatUser chatUser) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("uid", Long.valueOf(chatUser.getUk()));
        contentValues.put("buid", Long.valueOf(chatUser.getBuid()));
        contentValues.put("username", chatUser.getUserName());
        contentValues.put(TableDefine.UserInfoColumns.COLUMN_HEAD_URL, chatUser.getIconUrl());
        contentValues.put(TableDefine.UserInfoColumns.COLUMN_TINY_URL, chatUser.getTinyUrl());
        contentValues.put("sex", Integer.valueOf(chatUser.getSex()));
        contentValues.put(TableDefine.UserInfoColumns.COLUMN_USER_DETAIL, chatUser.getUserDetail());
        contentValues.put("phone", Long.valueOf(chatUser.getPhone()));
        contentValues.put("account_type", Integer.valueOf(chatUser.getAccountType()));
        contentValues.put("disturb", Integer.valueOf(chatUser.getDisturb()));
        contentValues.put(TableDefine.UserInfoColumns.COLUMN_BLACKLIST, Integer.valueOf(chatUser.getBlack()));
        contentValues.put("v_portrait", chatUser.getVPortrait());
        contentValues.put("vip_id", chatUser.getVipId());
        contentValues.put("identity", chatUser.getIdentity());
        contentValues.put(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, Long.valueOf(chatUser.getLastUpdate()));
        contentValues.put("shield", Integer.valueOf(chatUser.getShield()));
        contentValues.put("shield_time", Long.valueOf(chatUser.getShieldTime()));
        contentValues.put("marktop", Integer.valueOf(chatUser.getMarkTop()));
        contentValues.put(TableDefine.UserInfoColumns.COLUMN_MARKTOP_TIME, Long.valueOf(chatUser.getMarkTopTime()));
        contentValues.put(TableDefine.UserInfoColumns.COLUMN_SUBSCRIBE_STATUS, Integer.valueOf(chatUser.getSubscribe()));
        contentValues.put(TableDefine.UserInfoColumns.COLUMN_PHONE_RELATION, Integer.valueOf(chatUser.getPhoneRelation()));
        contentValues.put(TableDefine.UserInfoColumns.COLUMN_HAS_SPECIAL_IDENTITY, Integer.valueOf(chatUser.getHasSpecialIdentity()));
        contentValues.put(TableDefine.UserInfoColumns.COLUMN_SPECIAL_IDENTITY, chatUser.getSpecialIdentity());
        contentValues.put(TableDefine.UserInfoColumns.COLUMN_USER_EXT, chatUser.getUserExt());
        return contentValues;
    }

    public boolean isUserExist(SQLiteDatabase sQLiteDatabase, long j) {
        boolean z;
        synchronized (mSyncLock) {
            z = queryCount(TableDefine.DB_TABLE_USERINFO, new String[]{"uid"}, "uid=?", new String[]{String.valueOf(j)}) > 0;
        }
        return z;
    }

    public void updateUserIdentity(List<ChatUser> list) {
        if (list != null && list.size() > 0) {
            synchronized (mSyncLock) {
                for (ChatUser chatUser : list) {
                    ContentValues contentValues = new ContentValues();
                    if (chatUser.getUk() > 0) {
                        contentValues.put("uid", Long.valueOf(chatUser.getUk()));
                    }
                    contentValues.put("buid", Long.valueOf(chatUser.getBuid()));
                    contentValues.put("username", chatUser.getUserName());
                    contentValues.put(TableDefine.UserInfoColumns.COLUMN_HEAD_URL, chatUser.getIconUrl());
                    contentValues.put("v_portrait", chatUser.getVPortrait());
                    contentValues.put("vip_id", chatUser.getVipId());
                    contentValues.put("identity", chatUser.getIdentity());
                    contentValues.put(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, Long.valueOf(System.currentTimeMillis()));
                    contentValues.put(TableDefine.UserInfoColumns.COLUMN_SUBSCRIBE_STATUS, Integer.valueOf(chatUser.getSubscribe()));
                    contentValues.put(TableDefine.UserInfoColumns.COLUMN_PHONE_RELATION, Integer.valueOf(chatUser.getPhoneRelation()));
                    contentValues.put(TableDefine.UserInfoColumns.COLUMN_HAS_SPECIAL_IDENTITY, Integer.valueOf(chatUser.getHasSpecialIdentity()));
                    contentValues.put(TableDefine.UserInfoColumns.COLUMN_SPECIAL_IDENTITY, chatUser.getSpecialIdentity());
                    contentValues.put(TableDefine.UserInfoColumns.COLUMN_USER_EXT, chatUser.getUserExt());
                    add(TableDefine.DB_TABLE_USERINFO, new String[]{"buid"}, "buid = ? ", new String[]{String.valueOf(chatUser.getBuid())}, contentValues);
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [186=5, 187=4] */
    public Long getUkByBuid(long j) {
        Cursor cursor;
        Cursor cursor2 = null;
        synchronized (mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            try {
                if (openDatabase == null) {
                    return null;
                }
                try {
                    cursor = openDatabase.query(TableDefine.DB_TABLE_USERINFO, new String[]{"uid"}, "buid =? ", new String[]{String.valueOf(j)}, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst()) {
                                Long valueOf = Long.valueOf(cursor.getLong(cursor.getColumnIndex("uid")));
                                if (cursor != null) {
                                    cursor.close();
                                }
                                return valueOf;
                            }
                        } catch (Exception e) {
                            e = e;
                            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                            LogUtils.e(TAG, "getChatUser:", e);
                            if (cursor != null) {
                                cursor.close();
                            }
                            return null;
                        }
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Exception e2) {
                    e = e2;
                    cursor = null;
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        cursor2.close();
                    }
                    throw th;
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public ChatUser getChatUserByBuid(long j) {
        ChatUser chatUser = null;
        synchronized (mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase != null) {
                try {
                    chatUser = getChatUserByBuid(openDatabase, j);
                } catch (Exception e) {
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                    LogUtils.e(TAG, "getChatUser:", e);
                }
            }
        }
        return chatUser;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [225=5, 226=4] */
    private ChatUser getChatUserByBuid(SQLiteDatabase sQLiteDatabase, long j) {
        Cursor cursor;
        Cursor cursor2 = null;
        try {
            if (sQLiteDatabase == null) {
                return null;
            }
            try {
                cursor = sQLiteDatabase.query(TableDefine.DB_TABLE_USERINFO, null, "buid =? ", new String[]{String.valueOf(j)}, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            ChatUser constructChatUser = constructChatUser(cursor);
                            if (cursor != null) {
                                cursor.close();
                                return constructChatUser;
                            }
                            return constructChatUser;
                        }
                    } catch (Exception e) {
                        e = e;
                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                        LogUtils.e(TAG, "getChatUser:", e);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return null;
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    cursor2.close();
                }
                throw th;
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public LongSparseArray<ChatUser> getChatUserByBduids(List<Long> list) {
        Cursor cursor = null;
        if (list == null || list.size() <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder(list.get(0) + "");
        for (int i = 1; i < list.size(); i++) {
            sb.append(", " + list.get(i));
        }
        String str = "buid in (" + sb.toString() + ") ";
        LongSparseArray<ChatUser> longSparseArray = new LongSparseArray<>();
        synchronized (mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                return null;
            }
            try {
                cursor = openDatabase.query(TableDefine.DB_TABLE_USERINFO, null, str, null, null, null, null);
                while (cursor != null) {
                    if (!cursor.moveToNext()) {
                        break;
                    }
                    ChatUser constructChatUser = constructChatUser(cursor);
                    longSparseArray.put(constructChatUser.getBuid(), constructChatUser);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(TAG, "getChatUser:", e);
                if (cursor != null) {
                    cursor.close();
                }
            }
            return longSparseArray;
        }
    }

    public List<Long> getNotExpiredChatUserByBduids(List<Long> list, long j) {
        Cursor cursor = null;
        if (list == null || list.size() <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder(list.get(0) + "");
        for (int i = 1; i < list.size(); i++) {
            sb.append(", " + list.get(i));
        }
        String str = "buid in (" + sb.toString() + ") AND " + TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME + " > " + j;
        ArrayList arrayList = new ArrayList();
        synchronized (mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                return null;
            }
            try {
                cursor = openDatabase.query(TableDefine.DB_TABLE_USERINFO, new String[]{"buid"}, str, null, null, null, null);
                while (cursor != null) {
                    if (!cursor.moveToNext()) {
                        break;
                    }
                    arrayList.add(Long.valueOf(cursor.getLong(cursor.getColumnIndex("buid"))));
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(TAG, "getChatUser:", e);
                if (cursor != null) {
                    cursor.close();
                }
            }
            return arrayList;
        }
    }

    public ChatUser getChatUser(long j) {
        ChatUser chatUser = null;
        synchronized (mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase != null) {
                try {
                    chatUser = getChatUser(openDatabase, j);
                } catch (Exception e) {
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                    LogUtils.e(TAG, "getChatUser:", e);
                }
            }
        }
        return chatUser;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [340=5, 341=4] */
    private ChatUser getChatUser(SQLiteDatabase sQLiteDatabase, long j) {
        Cursor cursor;
        Cursor cursor2 = null;
        try {
            if (sQLiteDatabase == null) {
                return null;
            }
            try {
                cursor = sQLiteDatabase.query(TableDefine.DB_TABLE_USERINFO, null, "uid =? ", new String[]{String.valueOf(j)}, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            ChatUser constructChatUser = constructChatUser(cursor);
                            if (cursor != null) {
                                cursor.close();
                                return constructChatUser;
                            }
                            return constructChatUser;
                        }
                    } catch (Exception e) {
                        e = e;
                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                        LogUtils.e(TAG, "getChatUser:", e);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return null;
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    cursor2.close();
                }
                throw th;
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [365=4] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005e A[Catch: all -> 0x0062, TryCatch #1 {, blocks: (B:4:0x0004, B:6:0x000f, B:22:0x0054, B:23:0x0057, B:18:0x004c, B:19:0x004f, B:28:0x005e, B:29:0x0061), top: B:39:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList<ChatUser> getChatUser() {
        Cursor cursor;
        synchronized (mSyncLock) {
            ArrayList<ChatUser> arrayList = new ArrayList<>();
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                return null;
            }
            try {
                cursor = openDatabase.query(TableDefine.DB_TABLE_USERINFO, null, null, null, null, null, null);
                while (cursor != null) {
                    try {
                        try {
                            if (!cursor.moveToNext()) {
                                break;
                            }
                            arrayList.add(constructChatUser(cursor));
                        } catch (Exception e) {
                            e = e;
                            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                            LogUtils.e(TAG, "getChatUser:", e);
                            if (cursor != null) {
                                cursor.close();
                            }
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                if (cursor != null) {
                }
                throw th;
            }
        }
    }

    public int deleteChatUser(long j) {
        int delete;
        synchronized (mSyncLock) {
            delete = delete(TableDefine.DB_TABLE_USERINFO, "uid = ?", new String[]{String.valueOf(j)});
        }
        return delete;
    }

    private ChatUser constructChatUser(Cursor cursor) {
        long j = cursor.getLong(cursor.getColumnIndex("uid"));
        long j2 = cursor.getLong(cursor.getColumnIndex("buid"));
        String string = cursor.getString(cursor.getColumnIndex("username"));
        String string2 = cursor.getString(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_HEAD_URL));
        String string3 = cursor.getString(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_TINY_URL));
        String string4 = cursor.getString(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_USER_DETAIL));
        long j3 = cursor.getLong(cursor.getColumnIndex("phone"));
        int i = cursor.getInt(cursor.getColumnIndex("sex"));
        int i2 = cursor.getInt(cursor.getColumnIndex("account_type"));
        int i3 = cursor.getInt(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_IP_EXSIT));
        int i4 = cursor.getInt(cursor.getColumnIndex("disturb"));
        int i5 = cursor.getInt(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_BLACKLIST));
        String string5 = cursor.getString(cursor.getColumnIndex("v_portrait"));
        String string6 = cursor.getString(cursor.getColumnIndex("vip_id"));
        String string7 = cursor.getString(cursor.getColumnIndex("identity"));
        long j4 = cursor.getLong(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME));
        int i6 = cursor.getInt(cursor.getColumnIndex("shield"));
        long j5 = cursor.getLong(cursor.getColumnIndex("shield_time"));
        int i7 = cursor.getInt(cursor.getColumnIndex("marktop"));
        long j6 = cursor.getLong(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_MARKTOP_TIME));
        int i8 = cursor.getInt(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_SUBSCRIBE_STATUS));
        int i9 = cursor.getInt(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_PHONE_RELATION));
        int i10 = cursor.getInt(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_HAS_SPECIAL_IDENTITY));
        String string8 = cursor.getString(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_SPECIAL_IDENTITY));
        String string9 = cursor.getString(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_USER_EXT));
        ChatUser chatUser = new ChatUser(j, j2, string, string2);
        chatUser.setVPortrait(string5);
        chatUser.setVipId(string6);
        chatUser.setIdentity(string7);
        chatUser.setLastUpdate(j4);
        chatUser.setShield(i6);
        chatUser.setShieldTime(j5);
        chatUser.setMarkTop(i7);
        chatUser.setMarkTopTime(j6);
        chatUser.setSubscribe(i8);
        chatUser.setPhoneRelation(i9);
        chatUser.setHasSpecialIdentity(i10);
        chatUser.setSpecialIdentity(string8);
        chatUser.setUserExt(string9);
        if (i3 == 0) {
            IpInfo ipInfo = new IpInfo();
            ipInfo.setUid(j);
            String string10 = cursor.getString(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_IP));
            String string11 = cursor.getString(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_IP_ISP));
            String string12 = cursor.getString(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_IP_COUNTRY));
            String string13 = cursor.getString(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_IP_PROVINCE));
            String string14 = cursor.getString(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_IP_CITY));
            String string15 = cursor.getString(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_IP_COUNTY));
            ipInfo.setCity(string14);
            ipInfo.setProv(string13);
            ipInfo.setIp(string10);
            ipInfo.setCountry(string12);
            ipInfo.setCounty(string15);
            ipInfo.setIsp(string11);
            chatUser.setIpInfo(ipInfo);
        }
        chatUser.setIsIpLocationExist(i3);
        chatUser.setTinyUrl(string3);
        chatUser.setUserDetail(string4);
        chatUser.setSex(i);
        chatUser.setPhone(j3);
        chatUser.setAccountType(i2);
        chatUser.setDisturb(i4);
        chatUser.setBlack(i5);
        return chatUser;
    }

    public int updateUserIpInfo(ArrayList<IpInfo> arrayList) {
        int i = 0;
        synchronized (mSyncLock) {
            if (arrayList == null) {
                i = -1;
            } else if (arrayList.size() != 0) {
                ArrayList arrayList2 = new ArrayList(arrayList.size());
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    arrayList2.add(i2, new DBBase.UpdateArgs("uid= ?", new String[]{String.valueOf(arrayList.get(i2).getUid())}, constructIpInfoContentValue(arrayList.get(i2), new ContentValues())));
                }
                i = updateBatch(TableDefine.DB_TABLE_USERINFO, arrayList2);
            }
        }
        return i;
    }

    public int updateUserIp(long j, int i) {
        int update;
        synchronized (mSyncLock) {
            update = update(TableDefine.DB_TABLE_USERINFO, "uid= ?", new String[]{String.valueOf(j)}, constructIpInfoContentValue(null, new ContentValues()));
        }
        return update;
    }

    private ContentValues constructIpInfoContentValue(IpInfo ipInfo, ContentValues contentValues) {
        contentValues.put(TableDefine.UserInfoColumns.COLUMN_IP_EXSIT, String.valueOf(0));
        if (ipInfo != null) {
            contentValues.put(TableDefine.UserInfoColumns.COLUMN_IP, ipInfo.getIp());
            contentValues.put(TableDefine.UserInfoColumns.COLUMN_IP_ISP, ipInfo.getIsp());
            contentValues.put(TableDefine.UserInfoColumns.COLUMN_IP_COUNTRY, ipInfo.getCountry());
            contentValues.put(TableDefine.UserInfoColumns.COLUMN_IP_PROVINCE, ipInfo.getProv());
            contentValues.put(TableDefine.UserInfoColumns.COLUMN_IP_CITY, ipInfo.getCity());
            contentValues.put(TableDefine.UserInfoColumns.COLUMN_IP_COUNTY, ipInfo.getCounty());
        }
        return contentValues;
    }

    public boolean updateMarkTop(long j, int i, long j2) {
        boolean z = false;
        LogUtils.d(TAG, "updateMarkTop, uk =" + j + ", markToped=" + i + ", updateTime=" + j2);
        ContentValues contentValues = new ContentValues();
        contentValues.put("marktop", Integer.valueOf(i));
        contentValues.put(TableDefine.UserInfoColumns.COLUMN_MARKTOP_TIME, Long.valueOf(j2));
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("marktop", Integer.valueOf(i));
        contentValues2.put("marktoptime", Long.valueOf(j2));
        synchronized (mSyncLock) {
            boolean z2 = update(TableDefine.DB_TABLE_USERINFO, "uid =? ", new String[]{String.valueOf(j)}, contentValues) > 0;
            boolean z3 = update(TableDefine.DB_TABLE_CHAT_SESSION, "contacter =? ", new String[]{String.valueOf(j)}, contentValues2) > 0;
            if (z2 || z3) {
                z = true;
            }
        }
        return z;
    }

    public void updateMarkTopList(@NonNull final List<ChatSession> list) {
        TaskManager.getInstance(this.mContext).submitForLocalOperation(new Runnable() { // from class: com.baidu.android.imsdk.chatuser.db.ChatUserDBManager.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (ChatUserDBManager.mSyncLock) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("marktop", (Integer) 0);
                    ChatUserDBManager.this.update(TableDefine.DB_TABLE_USERINFO, "marktop=?", new String[]{String.valueOf(1)}, contentValues);
                    if (list != null) {
                        for (ChatSession chatSession : list) {
                            ChatUserDBManager.this.updateMarkTop(chatSession.getContacter(), chatSession.getMarkTop(), chatSession.getMarkTopTime());
                        }
                    }
                }
            }
        });
    }

    public boolean updateShield(@NonNull ChatSession chatSession, boolean z) {
        boolean z2 = false;
        synchronized (mSyncLock) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("shield", Integer.valueOf(chatSession.getShield()));
            contentValues.put("shield_time", Long.valueOf(chatSession.getShieldTime()));
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("shield", Integer.valueOf(chatSession.getShield()));
            contentValues2.put("shield_time", Long.valueOf(chatSession.getShieldTime()));
            if (z) {
                contentValues.put("marktop", Integer.valueOf(chatSession.getMarkTop()));
                contentValues.put(TableDefine.UserInfoColumns.COLUMN_MARKTOP_TIME, Long.valueOf(chatSession.getMarkTopTime()));
                contentValues2.put("marktop", Integer.valueOf(chatSession.getMarkTop()));
                contentValues2.put("marktoptime", Long.valueOf(chatSession.getMarkTopTime()));
            }
            long contacter = chatSession.getContacter();
            boolean z3 = update(TableDefine.DB_TABLE_USERINFO, "uid=?", new String[]{String.valueOf(contacter)}, contentValues) > 0;
            boolean z4 = update(TableDefine.DB_TABLE_CHAT_SESSION, "contacter =? ", new String[]{String.valueOf(contacter)}, contentValues2) > 0;
            LogUtils.d(TAG, "updateShield, uk =" + chatSession.getContacter() + ", shield=" + chatSession.getShield() + ", updateTime=" + chatSession.getShieldTime() + ", userUpdated :" + z3);
            if (z3 || z4) {
                z2 = true;
            }
        }
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAllShield(@NonNull final List<ChatSession> list) {
        if (list.size() > 0) {
            TaskManager.getInstance(this.mContext).submitForLocalOperation(new Runnable() { // from class: com.baidu.android.imsdk.chatuser.db.ChatUserDBManager.2
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (ChatUserDBManager.mSyncLock) {
                        for (ChatSession chatSession : list) {
                            ChatUserDBManager.this.updateShield(chatSession, false);
                        }
                    }
                }
            });
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [613=4] */
    public List<ChatSession> getShieldUsers() {
        Cursor cursor;
        Cursor cursor2 = null;
        synchronized (mSyncLock) {
            ArrayList arrayList = new ArrayList();
            SQLiteDatabase openDatabase = openDatabase();
            try {
                if (openDatabase == null) {
                    return null;
                }
                try {
                    cursor = openDatabase.query(TableDefine.DB_TABLE_USERINFO, null, "shield = ?", new String[]{String.valueOf(1)}, null, null, null, null);
                    while (cursor != null) {
                        try {
                            if (!cursor.moveToNext()) {
                                break;
                            }
                            arrayList.add(constructShieldUsers(new ChatSession(), cursor, true));
                        } catch (Exception e) {
                            e = e;
                            LogUtils.e(TAG, "getShieldUser:", e);
                            if (cursor != null) {
                                cursor.close();
                            }
                            return null;
                        }
                    }
                    LogUtils.d(TAG, "whereClause :shield = ?, users :" + arrayList.size());
                    if (cursor != null) {
                        cursor.close();
                    }
                    return arrayList;
                } catch (Exception e2) {
                    e = e2;
                    cursor = null;
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [686=4] */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0171: MOVE  (r9 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:47:0x0171 */
    public void getShieldUserByUids(@NonNull List<ChatSession> list, boolean z, @NonNull IGetUserShieldListener iGetUserShieldListener) {
        Cursor cursor;
        Cursor cursor2;
        ChatSession chatSession;
        synchronized (mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            ArrayList arrayList = new ArrayList();
            Cursor cursor3 = null;
            try {
                if (openDatabase == null) {
                    iGetUserShieldListener.onResult(-1, "db failed", null);
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("shield", (Integer) 0);
                    openDatabase.update(TableDefine.DB_TABLE_USERINFO, contentValues, "shield=?", new String[]{String.valueOf(1)});
                    String str = "";
                    if (list.size() > 0) {
                        String str2 = "" + list.get(0).getContacter();
                        for (int i = 1; i < list.size(); i++) {
                            str2 = str2 + ", " + list.get(i).getContacter();
                        }
                        str = "uid in (" + str2 + ") ";
                    }
                    cursor2 = openDatabase.query(TableDefine.DB_TABLE_USERINFO, null, str, null, null, null, null, null);
                    while (cursor2 != null) {
                        try {
                            if (!cursor2.moveToNext()) {
                                break;
                            }
                            long j = cursor2.getLong(cursor2.getColumnIndex("uid"));
                            ChatSession chatSession2 = new ChatSession();
                            int i2 = 0;
                            while (true) {
                                int i3 = i2;
                                if (i3 >= list.size()) {
                                    chatSession = chatSession2;
                                    break;
                                } else if (list.get(i3).getContacter() == j) {
                                    chatSession = list.get(i3);
                                    break;
                                } else {
                                    i2 = i3 + 1;
                                }
                            }
                            list.remove(chatSession);
                            arrayList.add(constructShieldUsers(chatSession, cursor2, false));
                        } catch (Exception e) {
                            e = e;
                            LogUtils.e(TAG, "getShieldUser:", e);
                            iGetUserShieldListener.onResult(-1, "exception", null);
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                        }
                    }
                    LogUtils.d(TAG, "getShieldUserByUids whereClause :" + str + ", update :" + arrayList.size() + ", user :" + list.size());
                    updateAllShield(arrayList);
                    if (list.size() <= 0) {
                        iGetUserShieldListener.onResult(0, "ok", arrayList);
                    } else {
                        getUserInfo(list, arrayList, iGetUserShieldListener);
                    }
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                } catch (Exception e2) {
                    e = e2;
                    cursor2 = null;
                } catch (Throwable th) {
                    th = th;
                    if (cursor3 != null) {
                        cursor3.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor3 = cursor;
            }
        }
    }

    private void getUserInfo(@NonNull final List<ChatSession> list, @NonNull final List<ChatSession> list2, @NonNull final IGetUserShieldListener iGetUserShieldListener) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(Long.valueOf(list.get(i).getContacter()));
        }
        LogUtils.i(TAG, "getUserInfo uks " + arrayList.toString() + ", hasResult :" + list2.size());
        long[] jArr = new long[arrayList.size()];
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (arrayList.get(i2) != null) {
                jArr[i2] = ((Long) arrayList.get(i2)).longValue();
            }
        }
        if (jArr.length <= 0) {
            iGetUserShieldListener.onResult(-1, "getUser failed", list2);
        } else {
            AccountManagerImpl.getInstance(this.mContext).getUidByUk(jArr, new IGetUidByUkListener() { // from class: com.baidu.android.imsdk.chatuser.db.ChatUserDBManager.3
                @Override // com.baidu.android.imsdk.account.IGetUidByUkListener
                public void onGetUidByUkResult(int i3, String str, long[] jArr2, Map<Long, Long> map) {
                    if (i3 != 0) {
                        iGetUserShieldListener.onResult(-1, "getUser failed", list2);
                        return;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (Map.Entry<Long, Long> entry : map.entrySet()) {
                        if (entry.getValue().longValue() > 0) {
                            arrayList2.add(entry.getValue());
                        }
                    }
                    LogUtils.e(ChatUserDBManager.TAG, "getUidByUk  result :" + list2.size() + ", bduid :" + arrayList2.toString());
                    if (arrayList2.size() > 0) {
                        ChatUserManagerImpl.getInstance(ChatUserDBManager.this.mContext).updateUserIdentity(arrayList2, new IGetUserIdentityListener() { // from class: com.baidu.android.imsdk.chatuser.db.ChatUserDBManager.3.1
                            @Override // com.baidu.android.imsdk.chatuser.IGetUserIdentityListener
                            public void onGetUserIdentityResult(int i4, List<ChatUser> list3) {
                                if (i4 == 0) {
                                    if (list3 == null) {
                                        iGetUserShieldListener.onResult(-1, "getUser failed", list2);
                                        return;
                                    }
                                    for (ChatSession chatSession : list) {
                                        Iterator<ChatUser> it = list3.iterator();
                                        while (true) {
                                            if (it.hasNext()) {
                                                ChatUser next = it.next();
                                                if (next.getUk() == chatSession.getContacter()) {
                                                    list2.add(ChatUserDBManager.this.constructShieldUsersByChatUser(chatSession, next));
                                                    ChatUserDBManager.this.updateUser(next);
                                                    ChatMessageDBManager.getInstance(ChatUserDBManager.this.mContext).updateSessionClass(next);
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    iGetUserShieldListener.onResult(0, "ok", list2);
                                    ChatUserDBManager.this.updateAllShield(list2);
                                    return;
                                }
                                iGetUserShieldListener.onResult(-1, "getUser failed", list2);
                            }
                        });
                    } else {
                        iGetUserShieldListener.onResult(-1, "getUser failed", list2);
                    }
                }
            });
        }
    }

    private ChatSession constructShieldUsers(@NonNull ChatSession chatSession, @NonNull Cursor cursor, boolean z) {
        chatSession.setContacter(cursor.getLong(cursor.getColumnIndex("uid")));
        chatSession.setNickName(cursor.getString(cursor.getColumnIndex("username")));
        chatSession.setIconUrl(cursor.getString(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_HEAD_URL)));
        chatSession.setCertification(cursor.getString(cursor.getColumnIndex("identity")));
        chatSession.setVipId(cursor.getString(cursor.getColumnIndex("vip_id")));
        chatSession.setVPortrait(cursor.getString(cursor.getColumnIndex("v_portrait")));
        chatSession.setChatType(0);
        if (z) {
            chatSession.setShield(cursor.getInt(cursor.getColumnIndex("shield")));
            chatSession.setShieldTime(cursor.getLong(cursor.getColumnIndex("shield_time")));
        }
        return chatSession;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ChatSession constructShieldUsersByChatUser(@NonNull ChatSession chatSession, @NonNull ChatUser chatUser) {
        chatSession.setContacter(chatUser.getUk());
        chatSession.setNickName(chatUser.getUserName());
        chatSession.setIconUrl(chatUser.getIconUrl());
        chatSession.setCertification(chatUser.getIdentity());
        chatSession.setVPortrait(chatUser.getVPortrait());
        chatSession.setVipId(chatUser.getVipId());
        return chatSession;
    }

    public boolean updateSubscribedUser(long j, int i) {
        boolean z;
        ContentValues contentValues = new ContentValues();
        contentValues.put(TableDefine.UserInfoColumns.COLUMN_SUBSCRIBE_STATUS, Integer.valueOf(i));
        synchronized (mSyncLock) {
            z = update(TableDefine.DB_TABLE_USERINFO, "uid =? ", new String[]{String.valueOf(j)}, contentValues) > 0;
        }
        return z;
    }

    public void updateSubscribedUsers(@NonNull final Map<Long, Integer> map) {
        if (map.size() > 0) {
            TaskManager.getInstance(this.mContext).submitForLocalOperation(new Runnable() { // from class: com.baidu.android.imsdk.chatuser.db.ChatUserDBManager.4
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (ChatUserDBManager.mSyncLock) {
                        for (Map.Entry entry : map.entrySet()) {
                            ChatUserDBManager.this.updateSubscribedUser(((Long) entry.getKey()).longValue(), ((Integer) entry.getValue()).intValue());
                        }
                    }
                }
            });
        }
    }
}
