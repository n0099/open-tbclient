package com.baidu.android.imsdk.pubaccount.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.db.CursorParse;
import com.baidu.android.imsdk.db.DBBase;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.pubaccount.IGetPaInfosListener;
import com.baidu.android.imsdk.pubaccount.PaInfo;
import com.baidu.android.imsdk.pubaccount.PaManagerImpl;
import com.baidu.android.imsdk.shield.IGetUserShieldListener;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.fsg.base.statistics.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class PaInfoDBManager extends DBBase {
    private static final String TAG = PaInfoDBManager.class.getSimpleName();
    private static PaInfoDBManager mInstance = null;

    private PaInfoDBManager(Context context) {
        setContext(context);
    }

    public static PaInfoDBManager getInstance(Context context) {
        synchronized (mSyncLock) {
            if (mInstance == null) {
                mInstance = new PaInfoDBManager(context);
            }
        }
        return mInstance;
    }

    public long subscribePa(PaInfo paInfo) {
        long add;
        ContentValues contentValues = new ContentValues();
        contentValues.put("paid", Long.valueOf(paInfo.getPaId()));
        contentValues.put("nickname", paInfo.getNickName());
        contentValues.put("url", paInfo.getUrl());
        contentValues.put(TableDefine.PaSubscribeColumns.COLUMN_AVATAR, paInfo.getAvatar());
        contentValues.put("description", paInfo.getDescription());
        contentValues.put("acceptpush", Integer.valueOf(paInfo.isAcceptPush() ? 1 : 0));
        contentValues.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("detail", paInfo.getDetail());
        contentValues.put("tpl", Long.valueOf(paInfo.getTPL()));
        contentValues.put("disturb", Integer.valueOf(paInfo.getDisturb()));
        contentValues.put(TableDefine.PaSubscribeColumns.COLUMN_SUBTYPE, Integer.valueOf(paInfo.getSubtype()));
        contentValues.put("classtype", Integer.valueOf(paInfo.getClassType()));
        contentValues.put("classtitle", paInfo.getClassTitle());
        contentValues.put("classavatar", paInfo.getClassavatar());
        contentValues.put("classshow", Integer.valueOf(paInfo.getClassshow()));
        contentValues.put("status", Integer.valueOf(paInfo.getStatus()));
        contentValues.put("marktop", Integer.valueOf(paInfo.getMarkTop()));
        contentValues.put("marktoptime", Long.valueOf(paInfo.getMarkTopTime()));
        contentValues.put(TableDefine.PaSubscribeColumns.COLUMN_SUBSET_TYPE, Integer.valueOf(paInfo.getSubsetType()));
        contentValues.put(TableDefine.PaSubscribeColumns.COLUMN_PA_EXT, paInfo.getPaExt());
        contentValues.put("v_portrait", paInfo.getVPortrait());
        contentValues.put("identity", paInfo.getIdentity());
        contentValues.put("shield", Integer.valueOf(paInfo.getShield()));
        contentValues.put("shield_time", Long.valueOf(paInfo.getShieldTime()));
        contentValues.put(TableDefine.PaSubscribeColumns.COLUMN_HAS_IDENTITY, Integer.valueOf(paInfo.getHasIdentity()));
        contentValues.put("vip_id", paInfo.getVipId());
        contentValues.put(TableDefine.PaSubscribeColumns.COLUMN_SUBSCRIBE, Integer.valueOf(paInfo.getSubscribe()));
        contentValues.put(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT, paInfo.getThirdExt());
        synchronized (mSyncLock) {
            add = add(TableDefine.DB_TABLE_PA_SUBSCRIBE, new String[]{"paid"}, "paid=?", new String[]{String.valueOf(paInfo.getPaId())}, contentValues);
        }
        return add;
    }

    public int setPaQuickRelies(long j, String str, long j2) {
        int update;
        ContentValues contentValues = new ContentValues();
        contentValues.put(TableDefine.PaSubscribeColumns.COLUMN_REPLIES, str);
        contentValues.put(TableDefine.PaSubscribeColumns.COLUMN_REFRESH_TIME, Long.valueOf(j2));
        synchronized (mSyncLock) {
            update = update(TableDefine.DB_TABLE_PA_SUBSCRIBE, "paid=?", new String[]{String.valueOf(j)}, contentValues);
        }
        return update;
    }

    public int deleteAllSubscribedPa() {
        int delete;
        synchronized (mSyncLock) {
            delete = delete(TableDefine.DB_TABLE_PA_SUBSCRIBE, null, null);
        }
        return delete;
    }

    public int unSubscribePa(long j) {
        int delete;
        if (j < 0) {
            return -1;
        }
        synchronized (mSyncLock) {
            delete = delete(TableDefine.DB_TABLE_PA_SUBSCRIBE, "paid=?", new String[]{String.valueOf(j)});
        }
        return delete;
    }

    public PaInfo queryPaInfo(long j) {
        PaInfo result;
        PaInfoParse paInfoParse = new PaInfoParse();
        synchronized (mSyncLock) {
            query(TableDefine.DB_TABLE_PA_SUBSCRIBE, null, "paid = ?", new String[]{Long.toString(j)}, null, null, null, paInfoParse);
            result = paInfoParse.getResult();
        }
        return result;
    }

    public List<PaInfo> querySubscribedPaList() {
        List<PaInfo> result;
        PaInfoListParse paInfoListParse = new PaInfoListParse();
        synchronized (mSyncLock) {
            query(TableDefine.DB_TABLE_PA_SUBSCRIBE, null, null, null, null, null, null, paInfoListParse);
            result = paInfoListParse.getResult();
        }
        return result;
    }

    public List<PaInfo> queryPaInfoByChatType(int i) {
        List<PaInfo> result;
        PaInfoListParse paInfoListParse = new PaInfoListParse();
        synchronized (mSyncLock) {
            query(TableDefine.DB_TABLE_PA_SUBSCRIBE, null, "pasubtype=?", new String[]{Integer.toString(i)}, null, null, null, paInfoListParse);
            result = paInfoListParse.getResult();
        }
        return result;
    }

    public ArrayList<Long> queryPaidList() {
        ArrayList<Long> result;
        PaidParse paidParse = new PaidParse();
        synchronized (mSyncLock) {
            query(TableDefine.DB_TABLE_PA_SUBSCRIBE, new String[]{"paid"}, null, null, null, null, null, paidParse);
            result = paidParse.getResult();
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class PaInfoParse implements CursorParse {
        PaInfo info = null;

        PaInfoParse() {
        }

        @Override // com.baidu.android.imsdk.db.CursorParse
        public void parseCursor(Cursor cursor) {
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    this.info = PaInfoDBManager.this.constructPaInfo(cursor);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.android.imsdk.db.CursorParse
        public PaInfo getResult() {
            return this.info;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class PaInfoListParse implements CursorParse {
        List<PaInfo> paList = null;

        PaInfoListParse() {
        }

        @Override // com.baidu.android.imsdk.db.CursorParse
        public void parseCursor(Cursor cursor) {
            if (cursor != null) {
                this.paList = new ArrayList();
                while (cursor.moveToNext()) {
                    this.paList.add(PaInfoDBManager.this.constructPaInfo(cursor));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.android.imsdk.db.CursorParse
        public List<PaInfo> getResult() {
            return this.paList;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class PaidParse implements CursorParse {
        ArrayList<Long> paList = null;

        PaidParse() {
        }

        @Override // com.baidu.android.imsdk.db.CursorParse
        public void parseCursor(Cursor cursor) {
            if (cursor != null) {
                this.paList = new ArrayList<>();
                while (cursor.moveToNext()) {
                    this.paList.add(Long.valueOf(cursor.getLong(0)));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.android.imsdk.db.CursorParse
        public ArrayList<Long> getResult() {
            return this.paList;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PaInfo constructPaInfo(Cursor cursor) {
        long j = cursor.getLong(cursor.getColumnIndex("paid"));
        String string = cursor.getString(cursor.getColumnIndex("nickname"));
        String string2 = cursor.getString(cursor.getColumnIndex(TableDefine.PaSubscribeColumns.COLUMN_AVATAR));
        String string3 = cursor.getString(cursor.getColumnIndex("description"));
        int i = cursor.getInt(cursor.getColumnIndex("acceptpush"));
        String string4 = cursor.getString(cursor.getColumnIndex("url"));
        long j2 = cursor.getLong(cursor.getColumnIndex("timestamp"));
        String string5 = cursor.getString(cursor.getColumnIndex("detail"));
        long j3 = cursor.getLong(cursor.getColumnIndex("tpl"));
        int i2 = cursor.getInt(cursor.getColumnIndex("disturb"));
        int i3 = cursor.getInt(cursor.getColumnIndex(TableDefine.PaSubscribeColumns.COLUMN_SUBTYPE));
        int i4 = cursor.getInt(cursor.getColumnIndex("classtype"));
        int i5 = cursor.getInt(cursor.getColumnIndex("classshow"));
        String string6 = cursor.getString(cursor.getColumnIndex("classtitle"));
        String string7 = cursor.getString(cursor.getColumnIndex("classavatar"));
        int i6 = cursor.getInt(cursor.getColumnIndex("marktop"));
        long j4 = cursor.getLong(cursor.getColumnIndex("marktoptime"));
        int i7 = cursor.getInt(cursor.getColumnIndex("status"));
        String string8 = cursor.getString(cursor.getColumnIndex(TableDefine.PaSubscribeColumns.COLUMN_REPLIES));
        long j5 = cursor.getLong(cursor.getColumnIndex(TableDefine.PaSubscribeColumns.COLUMN_REFRESH_TIME));
        int i8 = cursor.getInt(cursor.getColumnIndex(TableDefine.PaSubscribeColumns.COLUMN_SUBSET_TYPE));
        String string9 = cursor.getString(cursor.getColumnIndex(TableDefine.PaSubscribeColumns.COLUMN_PA_EXT));
        String string10 = cursor.getString(cursor.getColumnIndex("v_portrait"));
        String string11 = cursor.getString(cursor.getColumnIndex("vip_id"));
        String string12 = cursor.getString(cursor.getColumnIndex("identity"));
        int i9 = cursor.getInt(cursor.getColumnIndex(TableDefine.PaSubscribeColumns.COLUMN_HAS_IDENTITY));
        int i10 = cursor.getInt(cursor.getColumnIndex("shield"));
        long j6 = cursor.getLong(cursor.getColumnIndex("shield_time"));
        int i11 = cursor.getInt(cursor.getColumnIndex(TableDefine.PaSubscribeColumns.COLUMN_SUBSCRIBE));
        String string13 = cursor.getString(cursor.getColumnIndex(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT));
        PaInfo paInfo = new PaInfo();
        paInfo.setPaId(j);
        paInfo.setNickName(string);
        paInfo.setAvatar(string2);
        paInfo.setDescription(string3);
        paInfo.setUrl(string4);
        paInfo.setAcceptPush(i == 1);
        paInfo.setSubcribeTime(j2);
        paInfo.setDetail(string5);
        paInfo.setTPL(j3);
        paInfo.setDisturb(i2);
        paInfo.setSubtype(i3);
        paInfo.setClassType(i4);
        paInfo.setClasstitle(string6);
        paInfo.setClassAvatar(string7);
        paInfo.setClassshow(i5);
        paInfo.setStatus(i7);
        paInfo.setMarkTop(i6);
        paInfo.setMarkTopTime(j4);
        paInfo.setRepliesStr(string8);
        paInfo.setLastRefreshTime(j5);
        paInfo.setSubsetType(i8);
        paInfo.setPaExt(string9);
        paInfo.setVPortrait(string10);
        paInfo.setHasIdentity(i9);
        paInfo.setShield(i10);
        paInfo.setShieldTime(j6);
        paInfo.setIdentity(string12);
        paInfo.setVipId(string11);
        paInfo.setSubscribe(i11);
        paInfo.setThirdExt(string13);
        return paInfo;
    }

    public boolean acceptPaPush(long j, boolean z) {
        boolean z2;
        ContentValues contentValues = new ContentValues();
        contentValues.put("acceptpush", Integer.valueOf(z ? 1 : 0));
        synchronized (mSyncLock) {
            z2 = update(TableDefine.DB_TABLE_PA_SUBSCRIBE, "paid=?", new String[]{String.valueOf(j)}, contentValues) > 0;
        }
        return z2;
    }

    public boolean updateDisturb(long j, int i) {
        boolean z;
        ContentValues contentValues = new ContentValues();
        contentValues.put("disturb", Integer.valueOf(i));
        synchronized (mSyncLock) {
            z = update(TableDefine.DB_TABLE_PA_SUBSCRIBE, "paid=?", new String[]{String.valueOf(j)}, contentValues) > 0;
        }
        return z;
    }

    public boolean updateSubsetType(long j, int i) {
        boolean z;
        ContentValues contentValues = new ContentValues();
        contentValues.put(TableDefine.PaSubscribeColumns.COLUMN_SUBSET_TYPE, Integer.valueOf(i));
        synchronized (mSyncLock) {
            z = update(TableDefine.DB_TABLE_PA_SUBSCRIBE, "paid=?", new String[]{String.valueOf(j)}, contentValues) > 0;
        }
        return z;
    }

    public boolean updateMarkTop(long j, int i, long j2) {
        boolean z = false;
        LogUtils.d(TAG, "updateMarkTop, paid=" + j + ", markToped=" + i + ", updateTime=" + j2);
        ContentValues contentValues = new ContentValues();
        contentValues.put("marktop", Integer.valueOf(i));
        contentValues.put("marktoptime", Long.valueOf(j2));
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("marktop", Integer.valueOf(i));
        contentValues2.put("marktoptime", Long.valueOf(j2));
        synchronized (mSyncLock) {
            boolean z2 = update(TableDefine.DB_TABLE_PA_SUBSCRIBE, "paid =? ", new String[]{String.valueOf(j)}, contentValues) > 0;
            boolean z3 = update(TableDefine.DB_TABLE_CHAT_SESSION, "contacter =? ", new String[]{String.valueOf(j)}, contentValues2) > 0;
            if (z2 || z3) {
                z = true;
            }
        }
        return z;
    }

    public void updateMarkTopList(@NonNull final List<ChatSession> list) {
        if (list.size() > 0) {
            TaskManager.getInstance(this.mContext).submitForLocalOperation(new Runnable() { // from class: com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (PaInfoDBManager.mSyncLock) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("marktop", (Integer) 0);
                        PaInfoDBManager.this.update(TableDefine.DB_TABLE_PA_SUBSCRIBE, "marktop=?", new String[]{String.valueOf(1)}, contentValues);
                        for (ChatSession chatSession : list) {
                            PaInfoDBManager.this.updateMarkTop(chatSession.getContacter(), chatSession.getMarkTop(), chatSession.getMarkTopTime());
                        }
                    }
                }
            });
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [370=4] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0039 A[Catch: all -> 0x0064, TRY_ENTER, TryCatch #0 {, blocks: (B:4:0x0006, B:6:0x000c, B:14:0x0039, B:15:0x003c, B:31:0x006b, B:32:0x006e, B:22:0x005f, B:23:0x0062), top: B:37:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006b A[Catch: all -> 0x0064, TRY_ENTER, TryCatch #0 {, blocks: (B:4:0x0006, B:6:0x000c, B:14:0x0039, B:15:0x003c, B:31:0x006b, B:32:0x006e, B:22:0x005f, B:23:0x0062), top: B:37:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isSubscribed(long j) {
        Cursor cursor;
        boolean z;
        synchronized (mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                return false;
            }
            try {
                cursor = openDatabase.query(TableDefine.DB_TABLE_PA_SUBSCRIBE, new String[]{"paid"}, "paid=?", new String[]{String.valueOf(j)}, null, null, null);
                if (cursor != null) {
                    try {
                        try {
                            if (cursor.getCount() > 0) {
                                z = true;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                return z;
                            }
                        } catch (Exception e) {
                            e = e;
                            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                            LogUtils.e(LogUtils.TAG, "isSubscribed:", e);
                            if (cursor != null) {
                                cursor.close();
                            }
                            return false;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                z = false;
                if (cursor != null) {
                }
                return z;
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

    public ArrayList<Long> queryPaIdByPaType(int i) {
        ArrayList<Long> result;
        PaidParse paidParse = new PaidParse();
        synchronized (mSyncLock) {
            query(TableDefine.DB_TABLE_PA_SUBSCRIBE, new String[]{"paid"}, "pasubtype = ?", new String[]{Integer.toString(i)}, null, null, null, paidParse);
            result = paidParse.getResult();
        }
        return result;
    }

    public boolean updateShield(@NonNull ChatSession chatSession, boolean z) {
        boolean z2 = false;
        ContentValues contentValues = new ContentValues();
        contentValues.put("shield", Integer.valueOf(chatSession.getShield()));
        contentValues.put("shield_time", Long.valueOf(chatSession.getShieldTime()));
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("shield", Integer.valueOf(chatSession.getShield()));
        contentValues2.put("shield_time", Long.valueOf(chatSession.getShieldTime()));
        if (z) {
            contentValues.put("marktop", Integer.valueOf(chatSession.getMarkTop()));
            contentValues.put("marktoptime", Long.valueOf(chatSession.getMarkTopTime()));
            contentValues2.put("marktop", Integer.valueOf(chatSession.getMarkTop()));
            contentValues2.put("marktoptime", Long.valueOf(chatSession.getMarkTopTime()));
        }
        synchronized (mSyncLock) {
            long contacter = chatSession.getContacter();
            boolean z3 = update(TableDefine.DB_TABLE_PA_SUBSCRIBE, "paid=?", new String[]{String.valueOf(contacter)}, contentValues) > 0;
            boolean z4 = update(TableDefine.DB_TABLE_CHAT_SESSION, "contacter =? ", new String[]{String.valueOf(contacter)}, contentValues2) > 0;
            LogUtils.d(TAG, "updateShield, paId =" + chatSession.getContacter() + ", shield=" + chatSession.getShield() + ", updateTime=" + chatSession.getShieldTime() + ", paUpdated :" + z3);
            if (z3 || z4) {
                z2 = true;
            }
        }
        return z2;
    }

    public void updateAllShield(@NonNull final List<ChatSession> list) {
        if (list.size() > 0) {
            TaskManager.getInstance(this.mContext).submitForLocalOperation(new Runnable() { // from class: com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager.2
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (PaInfoDBManager.mSyncLock) {
                        for (ChatSession chatSession : list) {
                            PaInfoDBManager.this.updateShield(chatSession, false);
                        }
                    }
                }
            });
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [476=4] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f3 A[Catch: all -> 0x00f7, TryCatch #3 {, blocks: (B:4:0x0005, B:6:0x0010, B:32:0x00e9, B:33:0x00ec, B:27:0x00b8, B:28:0x00bb, B:37:0x00f3, B:38:0x00f6), top: B:48:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<ChatSession> getShieldUsers(List<Integer> list) {
        Cursor cursor;
        Cursor cursor2 = null;
        synchronized (mSyncLock) {
            ArrayList arrayList = new ArrayList();
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                return null;
            }
            try {
                String str = "shield = ?";
                LogUtils.e(TAG, "shield = ?");
                if (list != null && list.size() > 0) {
                    String str2 = "" + list.get(0);
                    for (int i = 1; i < list.size(); i++) {
                        str2 = str2 + ", " + list.get(i);
                    }
                    str = "shield = ? AND pasubtype in (" + str2 + ") ";
                }
                cursor = openDatabase.query(TableDefine.DB_TABLE_PA_SUBSCRIBE, null, str, new String[]{String.valueOf(1)}, null, null, null, null);
                while (cursor != null) {
                    try {
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
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                }
                LogUtils.e(TAG, "whereClause :" + str + ", users :" + arrayList.size());
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                if (cursor2 != null) {
                }
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [547=4] */
    public void getShieldUserByPaId(@NonNull List<ChatSession> list, boolean z, @NonNull IGetUserShieldListener iGetUserShieldListener) {
        Cursor cursor;
        ChatSession chatSession;
        synchronized (mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            ArrayList arrayList = new ArrayList();
            Cursor cursor2 = null;
            if (openDatabase == null) {
                iGetUserShieldListener.onResult(-1, "db failed", null);
                return;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("shield", (Integer) 0);
                openDatabase.update(TableDefine.DB_TABLE_PA_SUBSCRIBE, contentValues, "shield=?", new String[]{String.valueOf(1)});
                String str = "";
                if (list.size() > 0) {
                    String str2 = "" + list.get(0).getContacter();
                    int i = 1;
                    while (i < list.size()) {
                        String str3 = str2 + ", " + list.get(i).getContacter();
                        i++;
                        str2 = str3;
                    }
                    str = "paid in (" + str2 + ") ";
                }
                cursor = openDatabase.query(TableDefine.DB_TABLE_PA_SUBSCRIBE, null, str, null, null, null, null, null);
                while (cursor != null) {
                    try {
                        try {
                            if (!cursor.moveToNext()) {
                                break;
                            }
                            long j = cursor.getLong(cursor.getColumnIndex("paid"));
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
                            arrayList.add(constructShieldUsers(chatSession, cursor, false));
                        } catch (Exception e) {
                            e = e;
                            LogUtils.e(TAG, "getShieldUser:", e);
                            iGetUserShieldListener.onResult(-1, b.k, null);
                            if (cursor != null) {
                                cursor.close();
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                }
                LogUtils.e(TAG, "getShieldUserByUids whereClause :" + str + ", update :" + arrayList.size() + ", user :" + list.size());
                updateAllShield(arrayList);
                if (list.size() <= 0) {
                    iGetUserShieldListener.onResult(0, "ok", arrayList);
                } else {
                    getPaInfo(list, arrayList, iGetUserShieldListener);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    private void getPaInfo(@NonNull final List<ChatSession> list, @NonNull final List<ChatSession> list2, @NonNull final IGetUserShieldListener iGetUserShieldListener) {
        ArrayList<Long> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                break;
            }
            arrayList.add(Long.valueOf(list.get(i2).getContacter()));
            i = i2 + 1;
        }
        LogUtils.i(TAG, "getPaInfo ids " + arrayList.toString());
        if (arrayList.size() <= 0) {
            iGetUserShieldListener.onResult(-1, "get paInfo error", list2);
        } else {
            PaManagerImpl.getInstance(this.mContext).getPaInfos(arrayList, new IGetPaInfosListener() { // from class: com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager.3
                @Override // com.baidu.android.imsdk.pubaccount.IGetPaInfosListener
                public void onResult(int i3, String str, ArrayList<PaInfo> arrayList2) {
                    if (i3 == 0) {
                        if (arrayList2 == null) {
                            iGetUserShieldListener.onResult(-1, "getUser failed", list2);
                            return;
                        }
                        for (ChatSession chatSession : list) {
                            Iterator<PaInfo> it = arrayList2.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    PaInfo next = it.next();
                                    if (next.getPaId() == chatSession.getContacter()) {
                                        list2.add(PaInfoDBManager.this.constructShieldUsersByPaInfo(chatSession, next));
                                        PaInfoDBManager.this.subscribePa(next);
                                        ChatMessageDBManager.getInstance(PaInfoDBManager.this.mContext).updateSessionClass(next);
                                        break;
                                    }
                                }
                            }
                        }
                        iGetUserShieldListener.onResult(0, "ok", list2);
                        PaInfoDBManager.this.updateAllShield(list2);
                        return;
                    }
                    iGetUserShieldListener.onResult(-1, "get paInfo error", list2);
                }
            });
        }
    }

    private ChatSession constructShieldUsers(@NonNull ChatSession chatSession, Cursor cursor, boolean z) {
        chatSession.setContacter(cursor.getLong(cursor.getColumnIndex("paid")));
        chatSession.setNickName(cursor.getString(cursor.getColumnIndex("nickname")));
        chatSession.setIconUrl(cursor.getString(cursor.getColumnIndex(TableDefine.PaSubscribeColumns.COLUMN_AVATAR)));
        chatSession.setClassAvatar(cursor.getString(cursor.getColumnIndex("url")));
        chatSession.setExt(cursor.getString(cursor.getColumnIndex(TableDefine.PaSubscribeColumns.COLUMN_PA_EXT)));
        chatSession.setCertification(cursor.getString(cursor.getColumnIndex("identity")));
        chatSession.setVPortrait(cursor.getString(cursor.getColumnIndex("v_portrait")));
        chatSession.setVipId(cursor.getString(cursor.getColumnIndex("vip_id")));
        if (z) {
            chatSession.setChatType(1);
            chatSession.setShield(cursor.getInt(cursor.getColumnIndex("shield")));
            chatSession.setShieldTime(cursor.getLong(cursor.getColumnIndex("shield_time")));
        }
        return chatSession;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ChatSession constructShieldUsersByPaInfo(@NonNull ChatSession chatSession, @NonNull PaInfo paInfo) {
        chatSession.setContacter(paInfo.getPaId());
        chatSession.setNickName(paInfo.getNickName());
        chatSession.setIconUrl(paInfo.getAvatar());
        chatSession.setClassAvatar(paInfo.getUrl());
        chatSession.setCertification(chatSession.getCertification());
        chatSession.setVPortrait(chatSession.getVPortrait());
        chatSession.setVipId(chatSession.getVipId());
        return chatSession;
    }

    public boolean updateSubscribedUser(long j, int i) {
        boolean z;
        ContentValues contentValues = new ContentValues();
        contentValues.put(TableDefine.PaSubscribeColumns.COLUMN_SUBSCRIBE, Integer.valueOf(i));
        synchronized (mSyncLock) {
            z = update(TableDefine.DB_TABLE_PA_SUBSCRIBE, "paid =? ", new String[]{String.valueOf(j)}, contentValues) > 0;
        }
        return z;
    }

    public void updateSubscribedPaList(@NonNull final Map<Long, Integer> map) {
        if (map.size() > 0) {
            TaskManager.getInstance(this.mContext).submitForLocalOperation(new Runnable() { // from class: com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager.4
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (PaInfoDBManager.mSyncLock) {
                        for (Map.Entry entry : map.entrySet()) {
                            PaInfoDBManager.this.updateSubscribedUser(((Long) entry.getKey()).longValue(), ((Integer) entry.getValue()).intValue());
                        }
                    }
                }
            });
        }
    }
}
