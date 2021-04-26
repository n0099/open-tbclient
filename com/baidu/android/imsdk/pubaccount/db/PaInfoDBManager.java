package com.baidu.android.imsdk.pubaccount.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
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
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class PaInfoDBManager extends DBBase {
    public static final String TAG = "PaInfoDBManager";
    public static PaInfoDBManager mInstance;

    /* loaded from: classes.dex */
    public class PaInfoListParse implements CursorParse {
        public List<PaInfo> paList = null;

        public PaInfoListParse() {
        }

        @Override // com.baidu.android.imsdk.db.CursorParse
        public void parseCursor(Cursor cursor) {
            if (cursor == null) {
                return;
            }
            this.paList = new ArrayList();
            while (cursor.moveToNext()) {
                this.paList.add(PaInfoDBManager.this.constructPaInfo(cursor));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.android.imsdk.db.CursorParse
        public List<PaInfo> getResult() {
            return this.paList;
        }
    }

    /* loaded from: classes.dex */
    public class PaInfoParse implements CursorParse {
        public PaInfo info = null;

        public PaInfoParse() {
        }

        @Override // com.baidu.android.imsdk.db.CursorParse
        public void parseCursor(Cursor cursor) {
            if (cursor == null) {
                return;
            }
            while (cursor.moveToNext()) {
                this.info = PaInfoDBManager.this.constructPaInfo(cursor);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.android.imsdk.db.CursorParse
        public PaInfo getResult() {
            return this.info;
        }
    }

    /* loaded from: classes.dex */
    public class PaidParse implements CursorParse {
        public ArrayList<Long> paList = null;

        public PaidParse() {
        }

        @Override // com.baidu.android.imsdk.db.CursorParse
        public void parseCursor(Cursor cursor) {
            if (cursor == null) {
                return;
            }
            this.paList = new ArrayList<>();
            while (cursor.moveToNext()) {
                this.paList.add(Long.valueOf(cursor.getLong(0)));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.android.imsdk.db.CursorParse
        public ArrayList<Long> getResult() {
            return this.paList;
        }
    }

    public PaInfoDBManager(Context context) {
        setContext(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PaInfo constructPaInfo(Cursor cursor) {
        long j = cursor.getLong(cursor.getColumnIndex("paid"));
        String string = cursor.getString(cursor.getColumnIndex("nickname"));
        String string2 = cursor.getString(cursor.getColumnIndex("avatar"));
        String string3 = cursor.getString(cursor.getColumnIndex("description"));
        int i2 = cursor.getInt(cursor.getColumnIndex("acceptpush"));
        String string4 = cursor.getString(cursor.getColumnIndex("url"));
        long j2 = cursor.getLong(cursor.getColumnIndex("timestamp"));
        String string5 = cursor.getString(cursor.getColumnIndex("detail"));
        long j3 = cursor.getLong(cursor.getColumnIndex("tpl"));
        int i3 = cursor.getInt(cursor.getColumnIndex("disturb"));
        int i4 = cursor.getInt(cursor.getColumnIndex(TableDefine.PaSubscribeColumns.COLUMN_SUBTYPE));
        int i5 = cursor.getInt(cursor.getColumnIndex("classtype"));
        int i6 = cursor.getInt(cursor.getColumnIndex("classshow"));
        String string6 = cursor.getString(cursor.getColumnIndex("classtitle"));
        String string7 = cursor.getString(cursor.getColumnIndex("classavatar"));
        int i7 = cursor.getInt(cursor.getColumnIndex("marktop"));
        long j4 = cursor.getLong(cursor.getColumnIndex("marktoptime"));
        int i8 = cursor.getInt(cursor.getColumnIndex("status"));
        String string8 = cursor.getString(cursor.getColumnIndex(TableDefine.PaSubscribeColumns.COLUMN_REPLIES));
        long j5 = cursor.getLong(cursor.getColumnIndex(TableDefine.PaSubscribeColumns.COLUMN_REFRESH_TIME));
        int i9 = cursor.getInt(cursor.getColumnIndex(TableDefine.PaSubscribeColumns.COLUMN_SUBSET_TYPE));
        String string9 = cursor.getString(cursor.getColumnIndex(TableDefine.PaSubscribeColumns.COLUMN_PA_EXT));
        String string10 = cursor.getString(cursor.getColumnIndex("v_portrait"));
        String string11 = cursor.getString(cursor.getColumnIndex("vip_id"));
        String string12 = cursor.getString(cursor.getColumnIndex("identity"));
        int i10 = cursor.getInt(cursor.getColumnIndex(TableDefine.PaSubscribeColumns.COLUMN_HAS_IDENTITY));
        int i11 = cursor.getInt(cursor.getColumnIndex("shield"));
        long j6 = cursor.getLong(cursor.getColumnIndex("shield_time"));
        int i12 = cursor.getInt(cursor.getColumnIndex(TableDefine.PaSubscribeColumns.COLUMN_SUBSCRIBE));
        String string13 = cursor.getString(cursor.getColumnIndex(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT));
        int i13 = cursor.getInt(cursor.getColumnIndex(TableDefine.PaSubscribeColumns.COLUMN_REJECT_MENU));
        PaInfo paInfo = new PaInfo();
        paInfo.setPaId(j);
        paInfo.setNickName(string);
        paInfo.setAvatar(string2);
        paInfo.setDescription(string3);
        paInfo.setUrl(string4);
        paInfo.setAcceptPush(i2 == 1);
        paInfo.setSubcribeTime(j2);
        paInfo.setDetail(string5);
        paInfo.setTPL(j3);
        paInfo.setDisturb(i3);
        paInfo.setSubtype(i4);
        paInfo.setClassType(i5);
        paInfo.setClasstitle(string6);
        paInfo.setClassAvatar(string7);
        paInfo.setClassshow(i6);
        paInfo.setStatus(i8);
        paInfo.setMarkTop(i7);
        paInfo.setMarkTopTime(j4);
        paInfo.setRepliesStr(string8);
        paInfo.setLastRefreshTime(j5);
        paInfo.setSubsetType(i9);
        paInfo.setPaExt(string9);
        paInfo.setVPortrait(string10);
        paInfo.setHasIdentity(i10);
        paInfo.setShield(i11);
        paInfo.setShieldTime(j6);
        paInfo.setIdentity(string12);
        paInfo.setVipId(string11);
        paInfo.setSubscribe(i12);
        paInfo.setThirdExt(string13);
        paInfo.setRejectMenu(i13);
        return paInfo;
    }

    private ChatSession constructShieldUsers(@NonNull ChatSession chatSession, Cursor cursor, boolean z) {
        chatSession.setContacter(cursor.getLong(cursor.getColumnIndex("paid")));
        chatSession.setNickName(cursor.getString(cursor.getColumnIndex("nickname")));
        chatSession.setIconUrl(cursor.getString(cursor.getColumnIndex("avatar")));
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

    public static PaInfoDBManager getInstance(Context context) {
        if (mInstance == null) {
            synchronized (PaInfoDBManager.class) {
                if (mInstance == null) {
                    mInstance = new PaInfoDBManager(context);
                }
            }
        }
        return mInstance;
    }

    private void getPaInfo(@NonNull final List<ChatSession> list, @NonNull final List<ChatSession> list2, @NonNull final IGetUserShieldListener iGetUserShieldListener) {
        ArrayList<Long> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < list.size(); i2++) {
            arrayList.add(Long.valueOf(list.get(i2).getContacter()));
        }
        String str = TAG;
        LogUtils.i(str, "getPaInfo ids " + arrayList.toString());
        if (arrayList.size() <= 0) {
            iGetUserShieldListener.onResult(-1, "get paInfo error", list2);
        } else {
            PaManagerImpl.getInstance(this.mContext).getPaInfos(arrayList, new IGetPaInfosListener() { // from class: com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager.3
                @Override // com.baidu.android.imsdk.pubaccount.IGetPaInfosListener
                public void onResult(int i3, String str2, ArrayList<PaInfo> arrayList2) {
                    if (i3 != 0) {
                        iGetUserShieldListener.onResult(-1, "get paInfo error", list2);
                    } else if (arrayList2 == null) {
                        iGetUserShieldListener.onResult(-1, "getUser failed", list2);
                    } else {
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
                    }
                }
            });
        }
    }

    public boolean acceptPaPush(long j, boolean z) {
        boolean z2;
        ContentValues contentValues = new ContentValues();
        contentValues.put("acceptpush", Integer.valueOf(z ? 1 : 0));
        synchronized (DBBase.mSyncLock) {
            z2 = true;
            if (update(TableDefine.DB_TABLE_PA_SUBSCRIBE, "paid=?", new String[]{String.valueOf(j)}, contentValues) <= 0) {
                z2 = false;
            }
        }
        return z2;
    }

    public int deleteAllSubscribedPa() {
        int delete;
        synchronized (DBBase.mSyncLock) {
            delete = delete(TableDefine.DB_TABLE_PA_SUBSCRIBE, null, null);
        }
        return delete;
    }

    public List<Long> getPaidListByPainfos(SparseArray<List<Integer>> sparseArray) {
        ArrayList arrayList = new ArrayList();
        if (sparseArray == null || sparseArray.size() <= 0) {
            return arrayList;
        }
        synchronized (DBBase.mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                return arrayList;
            }
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                int keyAt = sparseArray.keyAt(i2);
                List<Integer> list = sparseArray.get(keyAt);
                sb.append("(");
                sb.append("paSubscribe.pasubtype");
                sb.append("=");
                sb.append(keyAt);
                if (list != null && list.size() > 0) {
                    sb.append(" AND ");
                    sb.append("paSubscribe.subset_type");
                    sb.append(" in ");
                    sb.append("(");
                    for (Integer num : list) {
                        sb.append(num.intValue());
                        sb.append(",");
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    sb.append(SmallTailInfo.EMOTION_SUFFIX);
                }
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
                sb.append(" OR ");
            }
            sb.delete(sb.length() - 4, sb.length());
            Cursor cursor = null;
            try {
                String str = "SELECT paSubscribe.paid FROM " + TableDefine.DB_TABLE_PA_SUBSCRIBE + " INNER JOIN " + TableDefine.DB_TABLE_CHAT_SESSION + " ON chatrecord.contacter = paSubscribe.paid WHERE " + sb.toString();
                LogUtils.d(TAG, "getPaidListByPainfos sql = " + str);
                cursor = openDatabase.rawQuery(str, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        arrayList.add(Long.valueOf(cursor.getLong(cursor.getColumnIndex("paid"))));
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (Exception e2) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                LogUtils.e(TAG, "getPaidListByPainfos:", e2);
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x013f, code lost:
        if (r4 != null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0141, code lost:
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x015a, code lost:
        if (r4 != null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x015e, code lost:
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0163 A[Catch: all -> 0x0167, TryCatch #3 {, blocks: (B:4:0x0009, B:6:0x0016, B:7:0x001b, B:39:0x0141, B:50:0x015d, B:55:0x0163, B:56:0x0166), top: B:60:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void getShieldUserByPaId(@NonNull List<ChatSession> list, boolean z, @NonNull IGetUserShieldListener iGetUserShieldListener) {
        Cursor cursor;
        synchronized (DBBase.mSyncLock) {
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
                    try {
                        String str2 = "" + list.get(0).getContacter();
                        for (int i2 = 1; i2 < list.size(); i2++) {
                            str2 = str2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + list.get(i2).getContacter();
                        }
                        str = "paid in (" + str2 + ") ";
                    } catch (Exception e2) {
                        e = e2;
                        cursor = null;
                        LogUtils.e(TAG, "getShieldUser:", e);
                        iGetUserShieldListener.onResult(-1, "exception", null);
                    } catch (Throwable th) {
                        th = th;
                        if (cursor2 != null) {
                        }
                        throw th;
                    }
                }
                String str3 = str;
                cursor = openDatabase.query(TableDefine.DB_TABLE_PA_SUBSCRIBE, null, str3, null, null, null, null, null);
                while (cursor != null) {
                    try {
                        try {
                            if (!cursor.moveToNext()) {
                                break;
                            }
                            long j = cursor.getLong(cursor.getColumnIndex("paid"));
                            ChatSession chatSession = new ChatSession();
                            int i3 = 0;
                            while (true) {
                                if (i3 >= list.size()) {
                                    break;
                                } else if (list.get(i3).getContacter() == j) {
                                    chatSession = list.get(i3);
                                    break;
                                } else {
                                    i3++;
                                }
                            }
                            list.remove(chatSession);
                            arrayList.add(constructShieldUsers(chatSession, cursor, false));
                        } catch (Exception e3) {
                            e = e3;
                            LogUtils.e(TAG, "getShieldUser:", e);
                            iGetUserShieldListener.onResult(-1, "exception", null);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                }
                LogUtils.e(TAG, "getShieldUserByUids whereClause :" + str3 + ", update :" + arrayList.size() + ", user :" + list.size());
                updateAllShield(arrayList);
                if (list.size() <= 0) {
                    iGetUserShieldListener.onResult(0, "ok", arrayList);
                } else {
                    getPaInfo(list, arrayList, iGetUserShieldListener);
                }
            } catch (Exception e4) {
                e = e4;
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
                cursor2 = null;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00bf, code lost:
        if (r11 != null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00c1, code lost:
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00cf, code lost:
        if (r11 == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00d3, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<ChatSession> getShieldUsers(List<Integer> list) {
        ArrayList arrayList = new ArrayList();
        synchronized (DBBase.mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            Cursor cursor = null;
            if (openDatabase == null) {
                return arrayList;
            }
            try {
                String str = "shield = ?";
                LogUtils.e(TAG, "shield = ?");
                if (list != null && list.size() > 0) {
                    String str2 = "" + list.get(0);
                    for (int i2 = 1; i2 < list.size(); i2++) {
                        str2 = str2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + list.get(i2);
                    }
                    str = "shield = ? AND pasubtype in (" + str2 + ") ";
                }
                String str3 = str;
                cursor = openDatabase.query(TableDefine.DB_TABLE_PA_SUBSCRIBE, null, str3, new String[]{String.valueOf(1)}, null, null, null, null);
                while (cursor != null && cursor.moveToNext()) {
                    arrayList.add(constructShieldUsers(new ChatSession(), cursor, true));
                }
                LogUtils.e(TAG, "whereClause :" + str3 + ", users :" + arrayList.size());
            } catch (Exception e2) {
                LogUtils.e(TAG, "getShieldUser:", e2);
            }
        }
    }

    public boolean isSubscribed(long j) {
        synchronized (DBBase.mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            Cursor cursor = null;
            boolean z = false;
            if (openDatabase == null) {
                return false;
            }
            try {
                cursor = openDatabase.query(TableDefine.DB_TABLE_PA_SUBSCRIBE, new String[]{"paid"}, "paid=?", new String[]{String.valueOf(j)}, null, null, null);
                if (cursor != null) {
                    if (cursor.getCount() > 0) {
                        z = true;
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
                return z;
            } catch (Exception e2) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                LogUtils.e(LogUtils.TAG, "isSubscribed:", e2);
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            }
        }
    }

    public ArrayList<Long> queryPaIdByPaType(int i2) {
        ArrayList<Long> result;
        PaidParse paidParse = new PaidParse();
        synchronized (DBBase.mSyncLock) {
            query(TableDefine.DB_TABLE_PA_SUBSCRIBE, new String[]{"paid"}, "pasubtype = ?", new String[]{Integer.toString(i2)}, null, null, null, paidParse);
            result = paidParse.getResult();
        }
        return result;
    }

    public PaInfo queryPaInfo(long j) {
        PaInfo result;
        PaInfoParse paInfoParse = new PaInfoParse();
        synchronized (DBBase.mSyncLock) {
            query(TableDefine.DB_TABLE_PA_SUBSCRIBE, null, "paid = ?", new String[]{Long.toString(j)}, null, null, null, paInfoParse);
            result = paInfoParse.getResult();
        }
        return result;
    }

    public List<PaInfo> queryPaInfoByChatType(int i2) {
        List<PaInfo> result;
        PaInfoListParse paInfoListParse = new PaInfoListParse();
        synchronized (DBBase.mSyncLock) {
            query(TableDefine.DB_TABLE_PA_SUBSCRIBE, null, "pasubtype=?", new String[]{Integer.toString(i2)}, null, null, null, paInfoListParse);
            result = paInfoListParse.getResult();
        }
        return result;
    }

    public ArrayList<Long> queryPaidList() {
        ArrayList<Long> result;
        PaidParse paidParse = new PaidParse();
        synchronized (DBBase.mSyncLock) {
            query(TableDefine.DB_TABLE_PA_SUBSCRIBE, new String[]{"paid"}, null, null, null, null, null, paidParse);
            result = paidParse.getResult();
        }
        return result;
    }

    public List<PaInfo> querySubscribedPaList() {
        List<PaInfo> result;
        PaInfoListParse paInfoListParse = new PaInfoListParse();
        synchronized (DBBase.mSyncLock) {
            query(TableDefine.DB_TABLE_PA_SUBSCRIBE, null, null, null, null, null, null, paInfoListParse);
            result = paInfoListParse.getResult();
        }
        return result;
    }

    public int setPaQuickRelies(long j, String str, long j2) {
        int update;
        ContentValues contentValues = new ContentValues();
        contentValues.put(TableDefine.PaSubscribeColumns.COLUMN_REPLIES, str);
        contentValues.put(TableDefine.PaSubscribeColumns.COLUMN_REFRESH_TIME, Long.valueOf(j2));
        synchronized (DBBase.mSyncLock) {
            update = update(TableDefine.DB_TABLE_PA_SUBSCRIBE, "paid=?", new String[]{String.valueOf(j)}, contentValues);
        }
        return update;
    }

    public long subscribePa(PaInfo paInfo) {
        long add;
        ContentValues contentValues = new ContentValues();
        contentValues.put("paid", Long.valueOf(paInfo.getPaId()));
        contentValues.put("nickname", paInfo.getNickName());
        contentValues.put("url", paInfo.getUrl());
        contentValues.put("avatar", paInfo.getAvatar());
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
        contentValues.put(TableDefine.PaSubscribeColumns.COLUMN_REJECT_MENU, Integer.valueOf(paInfo.getRejectMenu()));
        synchronized (DBBase.mSyncLock) {
            add = add(TableDefine.DB_TABLE_PA_SUBSCRIBE, new String[]{"paid"}, "paid=?", new String[]{String.valueOf(paInfo.getPaId())}, contentValues);
        }
        return add;
    }

    public int unSubscribePa(long j) {
        int delete;
        if (j < 0) {
            return -1;
        }
        synchronized (DBBase.mSyncLock) {
            delete = delete(TableDefine.DB_TABLE_PA_SUBSCRIBE, "paid=?", new String[]{String.valueOf(j)});
        }
        return delete;
    }

    public void updateAllShield(@NonNull final List<ChatSession> list) {
        if (list.size() > 0) {
            TaskManager.getInstance(this.mContext).submitForLocalOperation(new Runnable() { // from class: com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager.2
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (DBBase.mSyncLock) {
                        for (ChatSession chatSession : list) {
                            PaInfoDBManager.this.updateShield(chatSession, false);
                        }
                    }
                }
            });
        }
    }

    public boolean updateDisturb(long j, int i2) {
        boolean z;
        ContentValues contentValues = new ContentValues();
        contentValues.put("disturb", Integer.valueOf(i2));
        synchronized (DBBase.mSyncLock) {
            z = true;
            if (update(TableDefine.DB_TABLE_PA_SUBSCRIBE, "paid=?", new String[]{String.valueOf(j)}, contentValues) <= 0) {
                z = false;
            }
        }
        return z;
    }

    public boolean updateMarkTop(long j, int i2, long j2) {
        boolean z;
        String str = TAG;
        LogUtils.d(str, "updateMarkTop, paid=" + j + ", markToped=" + i2 + ", updateTime=" + j2);
        ContentValues contentValues = new ContentValues();
        contentValues.put("marktop", Integer.valueOf(i2));
        contentValues.put("marktoptime", Long.valueOf(j2));
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("marktop", Integer.valueOf(i2));
        contentValues2.put("marktoptime", Long.valueOf(j2));
        synchronized (DBBase.mSyncLock) {
            z = true;
            boolean z2 = update(TableDefine.DB_TABLE_PA_SUBSCRIBE, "paid =? ", new String[]{String.valueOf(j)}, contentValues) > 0;
            boolean z3 = update(TableDefine.DB_TABLE_CHAT_SESSION, "contacter =? ", new String[]{String.valueOf(j)}, contentValues2) > 0;
            if (!z2 && !z3) {
                z = false;
            }
        }
        return z;
    }

    public void updateMarkTopList(@NonNull final List<ChatSession> list) {
        TaskManager.getInstance(this.mContext).submitForLocalOperation(new Runnable() { // from class: com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (DBBase.mSyncLock) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("marktop", (Integer) 0);
                    PaInfoDBManager.this.update(TableDefine.DB_TABLE_PA_SUBSCRIBE, "marktop=?", new String[]{String.valueOf(1)}, contentValues);
                    if (list != null) {
                        for (ChatSession chatSession : list) {
                            PaInfoDBManager.this.updateMarkTop(chatSession.getContacter(), chatSession.getMarkTop(), chatSession.getMarkTopTime());
                        }
                    }
                }
            }
        });
    }

    public boolean updateShield(@NonNull ChatSession chatSession, boolean z) {
        boolean z2;
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
        synchronized (DBBase.mSyncLock) {
            long contacter = chatSession.getContacter();
            z2 = true;
            boolean z3 = update(TableDefine.DB_TABLE_PA_SUBSCRIBE, "paid=?", new String[]{String.valueOf(contacter)}, contentValues) > 0;
            boolean z4 = update(TableDefine.DB_TABLE_CHAT_SESSION, "contacter =? ", new String[]{String.valueOf(contacter)}, contentValues2) > 0;
            String str = TAG;
            LogUtils.d(str, "updateShield, paId =" + chatSession.getContacter() + ", shield=" + chatSession.getShield() + ", updateTime=" + chatSession.getShieldTime() + ", paUpdated :" + z3);
            if (!z3 && !z4) {
                z2 = false;
            }
        }
        return z2;
    }

    public void updateSubscribedPaList(@NonNull final Map<Long, Integer> map) {
        if (map.size() > 0) {
            TaskManager.getInstance(this.mContext).submitForLocalOperation(new Runnable() { // from class: com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager.4
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (DBBase.mSyncLock) {
                        for (Map.Entry entry : map.entrySet()) {
                            PaInfoDBManager.this.updateSubscribedUser(((Long) entry.getKey()).longValue(), ((Integer) entry.getValue()).intValue());
                        }
                    }
                }
            });
        }
    }

    public boolean updateSubscribedUser(long j, int i2) {
        boolean z;
        ContentValues contentValues = new ContentValues();
        contentValues.put(TableDefine.PaSubscribeColumns.COLUMN_SUBSCRIBE, Integer.valueOf(i2));
        synchronized (DBBase.mSyncLock) {
            z = true;
            if (update(TableDefine.DB_TABLE_PA_SUBSCRIBE, "paid =? ", new String[]{String.valueOf(j)}, contentValues) <= 0) {
                z = false;
            }
        }
        return z;
    }

    public boolean updateSubsetType(long j, int i2) {
        boolean z;
        ContentValues contentValues = new ContentValues();
        contentValues.put(TableDefine.PaSubscribeColumns.COLUMN_SUBSET_TYPE, Integer.valueOf(i2));
        synchronized (DBBase.mSyncLock) {
            z = true;
            if (update(TableDefine.DB_TABLE_PA_SUBSCRIBE, "paid=?", new String[]{String.valueOf(j)}, contentValues) <= 0) {
                z = false;
            }
        }
        return z;
    }
}
