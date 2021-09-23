package com.baidu.android.imsdk.pubaccount.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.db.CursorParse;
import com.baidu.android.imsdk.db.DBBase;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.pubaccount.IGetPaInfosListener;
import com.baidu.android.imsdk.pubaccount.PaInfo;
import com.baidu.android.imsdk.pubaccount.PaManagerImpl;
import com.baidu.android.imsdk.shield.IGetUserShieldListener;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.newbindcard.NewBindCardEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class PaInfoDBManager extends DBBase {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "PaInfoDBManager";
    public static PaInfoDBManager mInstance;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class PaInfoListParse implements CursorParse {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<PaInfo> paList;
        public final /* synthetic */ PaInfoDBManager this$0;

        public PaInfoListParse(PaInfoDBManager paInfoDBManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paInfoDBManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = paInfoDBManager;
            this.paList = null;
        }

        @Override // com.baidu.android.imsdk.db.CursorParse
        public void parseCursor(Cursor cursor) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cursor) == null) || cursor == null) {
                return;
            }
            this.paList = new ArrayList();
            while (cursor.moveToNext()) {
                this.paList.add(this.this$0.constructPaInfo(cursor));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.android.imsdk.db.CursorParse
        public List<PaInfo> getResult() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.paList : (List) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class PaInfoParse implements CursorParse {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public PaInfo info;
        public final /* synthetic */ PaInfoDBManager this$0;

        public PaInfoParse(PaInfoDBManager paInfoDBManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paInfoDBManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = paInfoDBManager;
            this.info = null;
        }

        @Override // com.baidu.android.imsdk.db.CursorParse
        public void parseCursor(Cursor cursor) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cursor) == null) || cursor == null) {
                return;
            }
            while (cursor.moveToNext()) {
                this.info = this.this$0.constructPaInfo(cursor);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.android.imsdk.db.CursorParse
        public PaInfo getResult() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.info : (PaInfo) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class PaidParse implements CursorParse {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ArrayList<Long> paList;
        public final /* synthetic */ PaInfoDBManager this$0;

        public PaidParse(PaInfoDBManager paInfoDBManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paInfoDBManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = paInfoDBManager;
            this.paList = null;
        }

        @Override // com.baidu.android.imsdk.db.CursorParse
        public void parseCursor(Cursor cursor) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cursor) == null) || cursor == null) {
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
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.paList : (ArrayList) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-384019420, "Lcom/baidu/android/imsdk/pubaccount/db/PaInfoDBManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-384019420, "Lcom/baidu/android/imsdk/pubaccount/db/PaInfoDBManager;");
        }
    }

    public PaInfoDBManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        setContext(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PaInfo constructPaInfo(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, cursor)) == null) {
            long j2 = cursor.getLong(cursor.getColumnIndex("paid"));
            String string = cursor.getString(cursor.getColumnIndex("nickname"));
            String string2 = cursor.getString(cursor.getColumnIndex("avatar"));
            String string3 = cursor.getString(cursor.getColumnIndex("description"));
            int i2 = cursor.getInt(cursor.getColumnIndex("acceptpush"));
            String string4 = cursor.getString(cursor.getColumnIndex("url"));
            long j3 = cursor.getLong(cursor.getColumnIndex("timestamp"));
            String string5 = cursor.getString(cursor.getColumnIndex("detail"));
            long j4 = cursor.getLong(cursor.getColumnIndex("tpl"));
            int i3 = cursor.getInt(cursor.getColumnIndex("disturb"));
            int i4 = cursor.getInt(cursor.getColumnIndex(TableDefine.PaSubscribeColumns.COLUMN_SUBTYPE));
            int i5 = cursor.getInt(cursor.getColumnIndex("classtype"));
            int i6 = cursor.getInt(cursor.getColumnIndex("classshow"));
            String string6 = cursor.getString(cursor.getColumnIndex("classtitle"));
            String string7 = cursor.getString(cursor.getColumnIndex("classavatar"));
            int i7 = cursor.getInt(cursor.getColumnIndex("marktop"));
            long j5 = cursor.getLong(cursor.getColumnIndex("marktoptime"));
            int i8 = cursor.getInt(cursor.getColumnIndex("status"));
            String string8 = cursor.getString(cursor.getColumnIndex(TableDefine.PaSubscribeColumns.COLUMN_REPLIES));
            long j6 = cursor.getLong(cursor.getColumnIndex(TableDefine.PaSubscribeColumns.COLUMN_REFRESH_TIME));
            int i9 = cursor.getInt(cursor.getColumnIndex(TableDefine.PaSubscribeColumns.COLUMN_SUBSET_TYPE));
            String string9 = cursor.getString(cursor.getColumnIndex(TableDefine.PaSubscribeColumns.COLUMN_PA_EXT));
            String string10 = cursor.getString(cursor.getColumnIndex("v_portrait"));
            String string11 = cursor.getString(cursor.getColumnIndex("vip_id"));
            String string12 = cursor.getString(cursor.getColumnIndex("identity"));
            int i10 = cursor.getInt(cursor.getColumnIndex(TableDefine.PaSubscribeColumns.COLUMN_HAS_IDENTITY));
            int i11 = cursor.getInt(cursor.getColumnIndex("shield"));
            long j7 = cursor.getLong(cursor.getColumnIndex("shield_time"));
            int i12 = cursor.getInt(cursor.getColumnIndex(TableDefine.PaSubscribeColumns.COLUMN_SUBSCRIBE));
            String string13 = cursor.getString(cursor.getColumnIndex(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT));
            int i13 = cursor.getInt(cursor.getColumnIndex(TableDefine.PaSubscribeColumns.COLUMN_REJECT_MENU));
            PaInfo paInfo = new PaInfo();
            paInfo.setPaId(j2);
            paInfo.setNickName(string);
            paInfo.setAvatar(string2);
            paInfo.setDescription(string3);
            paInfo.setUrl(string4);
            paInfo.setAcceptPush(i2 == 1);
            paInfo.setSubcribeTime(j3);
            paInfo.setDetail(string5);
            paInfo.setTPL(j4);
            paInfo.setDisturb(i3);
            paInfo.setSubtype(i4);
            paInfo.setClassType(i5);
            paInfo.setClasstitle(string6);
            paInfo.setClassAvatar(string7);
            paInfo.setClassshow(i6);
            paInfo.setStatus(i8);
            paInfo.setMarkTop(i7);
            paInfo.setMarkTopTime(j5);
            paInfo.setRepliesStr(string8);
            paInfo.setLastRefreshTime(j6);
            paInfo.setSubsetType(i9);
            paInfo.setPaExt(string9);
            paInfo.setVPortrait(string10);
            paInfo.setHasIdentity(i10);
            paInfo.setShield(i11);
            paInfo.setShieldTime(j7);
            paInfo.setIdentity(string12);
            paInfo.setVipId(string11);
            paInfo.setSubscribe(i12);
            paInfo.setThirdExt(string13);
            paInfo.setRejectMenu(i13);
            return paInfo;
        }
        return (PaInfo) invokeL.objValue;
    }

    private ChatSession constructShieldUsers(@NonNull ChatSession chatSession, Cursor cursor, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65546, this, chatSession, cursor, z)) == null) {
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
        return (ChatSession) invokeLLZ.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ChatSession constructShieldUsersByPaInfo(@NonNull ChatSession chatSession, @NonNull PaInfo paInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, this, chatSession, paInfo)) == null) {
            chatSession.setContacter(paInfo.getPaId());
            chatSession.setNickName(paInfo.getNickName());
            chatSession.setIconUrl(paInfo.getAvatar());
            chatSession.setClassAvatar(paInfo.getUrl());
            chatSession.setCertification(chatSession.getCertification());
            chatSession.setVPortrait(chatSession.getVPortrait());
            chatSession.setVipId(chatSession.getVipId());
            return chatSession;
        }
        return (ChatSession) invokeLL.objValue;
    }

    public static PaInfoDBManager getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            if (mInstance == null) {
                synchronized (PaInfoDBManager.class) {
                    if (mInstance == null) {
                        mInstance = new PaInfoDBManager(context);
                    }
                }
            }
            return mInstance;
        }
        return (PaInfoDBManager) invokeL.objValue;
    }

    private void getPaInfo(@NonNull List<ChatSession> list, @NonNull List<ChatSession> list2, @NonNull IGetUserShieldListener iGetUserShieldListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65549, this, list, list2, iGetUserShieldListener) == null) {
            ArrayList<Long> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < list.size(); i2++) {
                arrayList.add(Long.valueOf(list.get(i2).getContacter()));
            }
            String str = TAG;
            LogUtils.i(str, "getPaInfo ids " + arrayList.toString());
            if (arrayList.size() <= 0) {
                iGetUserShieldListener.onResult(-1, "get paInfo error", list2);
            } else {
                PaManagerImpl.getInstance(this.mContext).getPaInfos(arrayList, new IGetPaInfosListener(this, iGetUserShieldListener, list2, list) { // from class: com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PaInfoDBManager this$0;
                    public final /* synthetic */ IGetUserShieldListener val$listener;
                    public final /* synthetic */ List val$resultUsers;
                    public final /* synthetic */ List val$source;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, iGetUserShieldListener, list2, list};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$listener = iGetUserShieldListener;
                        this.val$resultUsers = list2;
                        this.val$source = list;
                    }

                    @Override // com.baidu.android.imsdk.pubaccount.IGetPaInfosListener
                    public void onResult(int i3, String str2, ArrayList<PaInfo> arrayList2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i3, str2, arrayList2) == null) {
                            if (i3 != 0) {
                                this.val$listener.onResult(-1, "get paInfo error", this.val$resultUsers);
                            } else if (arrayList2 == null) {
                                this.val$listener.onResult(-1, "getUser failed", this.val$resultUsers);
                            } else {
                                for (ChatSession chatSession : this.val$source) {
                                    Iterator<PaInfo> it = arrayList2.iterator();
                                    while (true) {
                                        if (it.hasNext()) {
                                            PaInfo next = it.next();
                                            if (next.getPaId() == chatSession.getContacter()) {
                                                this.val$resultUsers.add(this.this$0.constructShieldUsersByPaInfo(chatSession, next));
                                                this.this$0.subscribePa(next);
                                                ChatMessageDBManager.getInstance(this.this$0.mContext).updateSessionClass(next);
                                                break;
                                            }
                                        }
                                    }
                                }
                                this.val$listener.onResult(0, NewBindCardEntry.BING_CARD_SUCCESS_MSG, this.val$resultUsers);
                                this.this$0.updateAllShield(this.val$resultUsers);
                            }
                        }
                    }
                });
            }
        }
    }

    public boolean acceptPaPush(long j2, boolean z) {
        InterceptResult invokeCommon;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z)})) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("acceptpush", Integer.valueOf(z ? 1 : 0));
            synchronized (DBBase.mSyncLock) {
                z2 = true;
                if (update(TableDefine.DB_TABLE_PA_SUBSCRIBE, "paid=?", new String[]{String.valueOf(j2)}, contentValues) <= 0) {
                    z2 = false;
                }
            }
            return z2;
        }
        return invokeCommon.booleanValue;
    }

    public int deleteAllSubscribedPa() {
        InterceptResult invokeV;
        int delete;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (DBBase.mSyncLock) {
                delete = delete(TableDefine.DB_TABLE_PA_SUBSCRIBE, null, null);
            }
            return delete;
        }
        return invokeV.intValue;
    }

    public List<Long> getPaidListByPainfos(SparseArray<List<Integer>> sparseArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sparseArray)) == null) {
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
        return (List) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x00a4 */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0143, code lost:
        if (r4 != null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0145, code lost:
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x015e, code lost:
        if (r4 != null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0162, code lost:
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r15v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void getShieldUserByPaId(@NonNull List<ChatSession> list, boolean z, @NonNull IGetUserShieldListener iGetUserShieldListener) {
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(1048579, this, new Object[]{list, Boolean.valueOf(z), iGetUserShieldListener}) != null) {
            return;
        }
        synchronized (DBBase.mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            ArrayList arrayList = new ArrayList();
            ?? r15 = 0;
            try {
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
                            if (r15 != 0) {
                                r15.close();
                            }
                            throw th;
                        }
                    }
                    String str3 = str;
                    cursor = openDatabase.query(TableDefine.DB_TABLE_PA_SUBSCRIBE, null, str3, null, null, null, null, null);
                    while (cursor != null) {
                        try {
                            if (!cursor.moveToNext()) {
                                break;
                            }
                            long j2 = cursor.getLong(cursor.getColumnIndex("paid"));
                            ChatSession chatSession = new ChatSession();
                            int i3 = 0;
                            while (true) {
                                if (i3 >= list.size()) {
                                    break;
                                } else if (list.get(i3).getContacter() == j2) {
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
                    }
                    LogUtils.e(TAG, "getShieldUserByUids whereClause :" + str3 + ", update :" + arrayList.size() + ", user :" + list.size());
                    updateAllShield(arrayList);
                    if (list.size() <= 0) {
                        iGetUserShieldListener.onResult(0, NewBindCardEntry.BING_CARD_SUCCESS_MSG, arrayList);
                    } else {
                        getPaInfo(list, arrayList, iGetUserShieldListener);
                    }
                } catch (Exception e4) {
                    e = e4;
                    cursor = null;
                } catch (Throwable th2) {
                    th = th2;
                    r15 = 0;
                }
            } catch (Throwable th3) {
                th = th3;
                r15 = openDatabase;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00c4, code lost:
        if (r11 != null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00c6, code lost:
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00d4, code lost:
        if (r11 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00d8, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<ChatSession> getShieldUsers(List<Integer> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048580, this, list)) != null) {
            return (List) invokeL.objValue;
        }
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

    public boolean isSubscribed(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) {
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                Cursor cursor = null;
                boolean z = false;
                if (openDatabase == null) {
                    return false;
                }
                try {
                    cursor = openDatabase.query(TableDefine.DB_TABLE_PA_SUBSCRIBE, new String[]{"paid"}, "paid=?", new String[]{String.valueOf(j2)}, null, null, null);
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
        return invokeJ.booleanValue;
    }

    public ArrayList<Long> queryPaIdByPaType(int i2) {
        InterceptResult invokeI;
        ArrayList<Long> result;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            PaidParse paidParse = new PaidParse(this);
            synchronized (DBBase.mSyncLock) {
                query(TableDefine.DB_TABLE_PA_SUBSCRIBE, new String[]{"paid"}, "pasubtype = ?", new String[]{Integer.toString(i2)}, null, null, null, paidParse);
                result = paidParse.getResult();
            }
            return result;
        }
        return (ArrayList) invokeI.objValue;
    }

    public PaInfo queryPaInfo(long j2) {
        InterceptResult invokeJ;
        PaInfo result;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j2)) == null) {
            PaInfoParse paInfoParse = new PaInfoParse(this);
            synchronized (DBBase.mSyncLock) {
                query(TableDefine.DB_TABLE_PA_SUBSCRIBE, null, "paid = ?", new String[]{Long.toString(j2)}, null, null, null, paInfoParse);
                result = paInfoParse.getResult();
            }
            return result;
        }
        return (PaInfo) invokeJ.objValue;
    }

    public List<PaInfo> queryPaInfoByChatType(int i2) {
        InterceptResult invokeI;
        List<PaInfo> result;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            PaInfoListParse paInfoListParse = new PaInfoListParse(this);
            synchronized (DBBase.mSyncLock) {
                query(TableDefine.DB_TABLE_PA_SUBSCRIBE, null, "pasubtype=?", new String[]{Integer.toString(i2)}, null, null, null, paInfoListParse);
                result = paInfoListParse.getResult();
            }
            return result;
        }
        return (List) invokeI.objValue;
    }

    public ArrayList<Long> queryPaidList() {
        InterceptResult invokeV;
        ArrayList<Long> result;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PaidParse paidParse = new PaidParse(this);
            synchronized (DBBase.mSyncLock) {
                query(TableDefine.DB_TABLE_PA_SUBSCRIBE, new String[]{"paid"}, null, null, null, null, null, paidParse);
                result = paidParse.getResult();
            }
            return result;
        }
        return (ArrayList) invokeV.objValue;
    }

    public List<PaInfo> querySubscribedPaList() {
        InterceptResult invokeV;
        List<PaInfo> result;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            PaInfoListParse paInfoListParse = new PaInfoListParse(this);
            synchronized (DBBase.mSyncLock) {
                query(TableDefine.DB_TABLE_PA_SUBSCRIBE, null, null, null, null, null, null, paInfoListParse);
                result = paInfoListParse.getResult();
            }
            return result;
        }
        return (List) invokeV.objValue;
    }

    public int setPaQuickRelies(long j2, String str, long j3) {
        InterceptResult invokeCommon;
        int update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Long.valueOf(j2), str, Long.valueOf(j3)})) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(TableDefine.PaSubscribeColumns.COLUMN_REPLIES, str);
            contentValues.put(TableDefine.PaSubscribeColumns.COLUMN_REFRESH_TIME, Long.valueOf(j3));
            synchronized (DBBase.mSyncLock) {
                update = update(TableDefine.DB_TABLE_PA_SUBSCRIBE, "paid=?", new String[]{String.valueOf(j2)}, contentValues);
            }
            return update;
        }
        return invokeCommon.intValue;
    }

    public long subscribePa(PaInfo paInfo) {
        InterceptResult invokeL;
        long add;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, paInfo)) == null) {
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
        return invokeL.longValue;
    }

    public int unSubscribePa(long j2) {
        InterceptResult invokeJ;
        int delete;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048589, this, j2)) == null) {
            if (j2 < 0) {
                return -1;
            }
            synchronized (DBBase.mSyncLock) {
                delete = delete(TableDefine.DB_TABLE_PA_SUBSCRIBE, "paid=?", new String[]{String.valueOf(j2)});
            }
            return delete;
        }
        return invokeJ.intValue;
    }

    public void updateAllShield(@NonNull List<ChatSession> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, list) == null) || list.size() <= 0) {
            return;
        }
        TaskManager.getInstance(this.mContext).submitForLocalOperation(new Runnable(this, list) { // from class: com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PaInfoDBManager this$0;
            public final /* synthetic */ List val$users;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, list};
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
                this.val$users = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    synchronized (DBBase.mSyncLock) {
                        for (ChatSession chatSession : this.val$users) {
                            this.this$0.updateShield(chatSession, false);
                        }
                    }
                }
            }
        });
    }

    public boolean updateDisturb(long j2, int i2) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)})) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("disturb", Integer.valueOf(i2));
            synchronized (DBBase.mSyncLock) {
                z = true;
                if (update(TableDefine.DB_TABLE_PA_SUBSCRIBE, "paid=?", new String[]{String.valueOf(j2)}, contentValues) <= 0) {
                    z = false;
                }
            }
            return z;
        }
        return invokeCommon.booleanValue;
    }

    public boolean updateMarkTop(long j2, int i2, long j3) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3)})) == null) {
            String str = TAG;
            LogUtils.d(str, "updateMarkTop, paid=" + j2 + ", markToped=" + i2 + ", updateTime=" + j3);
            ContentValues contentValues = new ContentValues();
            contentValues.put("marktop", Integer.valueOf(i2));
            contentValues.put("marktoptime", Long.valueOf(j3));
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("marktop", Integer.valueOf(i2));
            contentValues2.put("marktoptime", Long.valueOf(j3));
            synchronized (DBBase.mSyncLock) {
                z = true;
                boolean z2 = update(TableDefine.DB_TABLE_PA_SUBSCRIBE, "paid =? ", new String[]{String.valueOf(j2)}, contentValues) > 0;
                boolean z3 = update(TableDefine.DB_TABLE_CHAT_SESSION, "contacter =? ", new String[]{String.valueOf(j2)}, contentValues2) > 0;
                if (!z2 && !z3) {
                    z = false;
                }
            }
            return z;
        }
        return invokeCommon.booleanValue;
    }

    public void updateMarkTopList(@NonNull List<ChatSession> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, list) == null) {
            TaskManager.getInstance(this.mContext).submitForLocalOperation(new Runnable(this, list) { // from class: com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PaInfoDBManager this$0;
                public final /* synthetic */ List val$users;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, list};
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
                    this.val$users = list;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (DBBase.mSyncLock) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("marktop", (Integer) 0);
                            this.this$0.update(TableDefine.DB_TABLE_PA_SUBSCRIBE, "marktop=?", new String[]{String.valueOf(1)}, contentValues);
                            if (this.val$users != null) {
                                for (ChatSession chatSession : this.val$users) {
                                    this.this$0.updateMarkTop(chatSession.getContacter(), chatSession.getMarkTop(), chatSession.getMarkTopTime());
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    public boolean updateShield(@NonNull ChatSession chatSession, boolean z) {
        InterceptResult invokeLZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048594, this, chatSession, z)) == null) {
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
        return invokeLZ.booleanValue;
    }

    public void updateSubscribedPaList(@NonNull Map<Long, Integer> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, map) == null) || map.size() <= 0) {
            return;
        }
        TaskManager.getInstance(this.mContext).submitForLocalOperation(new Runnable(this, map) { // from class: com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PaInfoDBManager this$0;
            public final /* synthetic */ Map val$uidStatusList;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, map};
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
                this.val$uidStatusList = map;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    synchronized (DBBase.mSyncLock) {
                        for (Map.Entry entry : this.val$uidStatusList.entrySet()) {
                            this.this$0.updateSubscribedUser(((Long) entry.getKey()).longValue(), ((Integer) entry.getValue()).intValue());
                        }
                    }
                }
            }
        });
    }

    public boolean updateSubscribedUser(long j2, int i2) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)})) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(TableDefine.PaSubscribeColumns.COLUMN_SUBSCRIBE, Integer.valueOf(i2));
            synchronized (DBBase.mSyncLock) {
                z = true;
                if (update(TableDefine.DB_TABLE_PA_SUBSCRIBE, "paid =? ", new String[]{String.valueOf(j2)}, contentValues) <= 0) {
                    z = false;
                }
            }
            return z;
        }
        return invokeCommon.booleanValue;
    }

    public boolean updateSubsetType(long j2, int i2) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)})) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(TableDefine.PaSubscribeColumns.COLUMN_SUBSET_TYPE, Integer.valueOf(i2));
            synchronized (DBBase.mSyncLock) {
                z = true;
                if (update(TableDefine.DB_TABLE_PA_SUBSCRIBE, "paid=?", new String[]{String.valueOf(j2)}, contentValues) <= 0) {
                    z = false;
                }
            }
            return z;
        }
        return invokeCommon.booleanValue;
    }
}
