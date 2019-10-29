package com.baidu.android.imsdk.chatuser.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.baidu.android.imsdk.chatuser.ChatUser;
import com.baidu.android.imsdk.chatuser.IpInfo;
import com.baidu.android.imsdk.db.DBBase;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class ChatUserDBManager extends DBBase {
    private static final String TAG = ChatUserDBManager.class.getSimpleName();
    private static ChatUserDBManager mInstance = null;

    private ChatUserDBManager(Context context) {
        setContext(context);
    }

    public static ChatUserDBManager getInstance(Context context) {
        synchronized (mSyncLock) {
            if (mInstance == null) {
                mInstance = new ChatUserDBManager(context);
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
        return contentValues;
    }

    public boolean isUserExist(SQLiteDatabase sQLiteDatabase, long j) {
        boolean z;
        synchronized (mSyncLock) {
            z = queryCount(TableDefine.DB_TABLE_USERINFO, new String[]{"uid"}, "uid=?", new String[]{String.valueOf(j)}) > 0;
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [113=5, 114=4, 116=4, 117=4] */
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
                                if (openDatabase != null) {
                                    closeDatabase();
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
                            if (openDatabase != null) {
                                closeDatabase();
                            }
                            return null;
                        }
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (openDatabase != null) {
                        closeDatabase();
                    }
                } catch (Exception e2) {
                    e = e2;
                    cursor = null;
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        cursor2.close();
                    }
                    if (openDatabase != null) {
                        closeDatabase();
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
                    if (openDatabase != null) {
                        closeDatabase();
                    }
                } catch (Exception e) {
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                    LogUtils.e(TAG, "getChatUser:", e);
                    if (openDatabase != null) {
                        closeDatabase();
                    }
                }
            }
        }
        return chatUser;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [160=4, 159=5] */
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

    public ChatUser getChatUser(long j) {
        ChatUser chatUser = null;
        synchronized (mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase != null) {
                try {
                    chatUser = getChatUser(openDatabase, j);
                    if (openDatabase != null) {
                        closeDatabase();
                    }
                } catch (Exception e) {
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                    LogUtils.e(TAG, "getChatUser:", e);
                    if (openDatabase != null) {
                        closeDatabase();
                    }
                }
            }
        }
        return chatUser;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [201=5, 202=4] */
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [226=4] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0068 A[Catch: all -> 0x0071, TryCatch #1 {, blocks: (B:4:0x0004, B:6:0x000f, B:24:0x0059, B:26:0x005e, B:27:0x0061, B:18:0x004c, B:20:0x0051, B:21:0x0054, B:32:0x0068, B:34:0x006d, B:35:0x0070), top: B:45:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006d A[Catch: all -> 0x0071, TryCatch #1 {, blocks: (B:4:0x0004, B:6:0x000f, B:24:0x0059, B:26:0x005e, B:27:0x0061, B:18:0x004c, B:20:0x0051, B:21:0x0054, B:32:0x0068, B:34:0x006d, B:35:0x0070), top: B:45:0x0004 }] */
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
                            if (openDatabase != null) {
                                closeDatabase();
                            }
                            if (cursor != null) {
                                cursor.close();
                            }
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (openDatabase != null) {
                            closeDatabase();
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                if (openDatabase != null) {
                    closeDatabase();
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
                if (openDatabase != null) {
                }
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
        ChatUser chatUser = new ChatUser(j, j2, string, string2);
        if (i3 == 0) {
            IpInfo ipInfo = new IpInfo();
            ipInfo.setUid(j);
            String string5 = cursor.getString(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_IP));
            String string6 = cursor.getString(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_IP_ISP));
            String string7 = cursor.getString(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_IP_COUNTRY));
            String string8 = cursor.getString(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_IP_PROVINCE));
            String string9 = cursor.getString(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_IP_CITY));
            String string10 = cursor.getString(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_IP_COUNTY));
            ipInfo.setCity(string9);
            ipInfo.setProv(string8);
            ipInfo.setIp(string5);
            ipInfo.setCountry(string7);
            ipInfo.setCounty(string10);
            ipInfo.setIsp(string6);
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
}
