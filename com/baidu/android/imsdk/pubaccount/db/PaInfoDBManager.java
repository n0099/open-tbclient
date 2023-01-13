package com.baidu.android.imsdk.pubaccount.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.db.CursorParse;
import com.baidu.android.imsdk.db.CursorWrapper;
import com.baidu.android.imsdk.db.DBBase;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.media.db.MediaMessageDBManager;
import com.baidu.android.imsdk.pubaccount.IGetPaInfosListener;
import com.baidu.android.imsdk.pubaccount.PaInfo;
import com.baidu.android.imsdk.pubaccount.PaManagerImpl;
import com.baidu.android.imsdk.shield.IGetUserShieldListener;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PaInfoDBManager extends DBBase {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "PaInfoDBManager";
    public static PaInfoDBManager mInstance;
    public transient /* synthetic */ FieldHolder $fh;

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

    /* loaded from: classes.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cursor) != null) || cursor == null) {
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
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.paList;
            }
            return (List) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cursor) != null) || cursor == null) {
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
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.info;
            }
            return (PaInfo) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cursor) != null) || cursor == null) {
                return;
            }
            this.paList = new ArrayList<>();
            while (cursor.moveToNext()) {
                this.paList.add(Long.valueOf(CursorWrapper.getLong(cursor, "paid")));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.android.imsdk.db.CursorParse
        public ArrayList<Long> getResult() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.paList;
            }
            return (ArrayList) invokeV.objValue;
        }
    }

    public PaInfoDBManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        setContext(context);
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

    public void updateAllShield(@NonNull List<ChatSession> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, list) == null) && list.size() > 0) {
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
                    if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                        return;
                    }
                    synchronized (DBBase.mSyncLock) {
                        for (ChatSession chatSession : this.val$users) {
                            this.this$0.updateShield(chatSession, false, true);
                        }
                    }
                }
            });
        }
    }

    public void updateMarkTopList(@NonNull List<ChatSession> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, list) == null) {
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
                    if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                        return;
                    }
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
            });
        }
    }

    public void updateSubscribedPaList(@NonNull Map<Long, Integer> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, map) == null) && map.size() > 0) {
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
                    if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                        return;
                    }
                    synchronized (DBBase.mSyncLock) {
                        for (Map.Entry entry : this.val$uidStatusList.entrySet()) {
                            this.this$0.updateSubscribedUser(((Long) entry.getKey()).longValue(), ((Integer) entry.getValue()).intValue());
                        }
                    }
                }
            });
        }
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

    public List<PaInfo> querySubscribedPaList() {
        InterceptResult invokeV;
        List<PaInfo> result;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            PaInfoListParse paInfoListParse = new PaInfoListParse(this);
            synchronized (DBBase.mSyncLock) {
                query(TableDefine.DB_TABLE_PA_SUBSCRIBE, null, null, null, null, null, null, paInfoListParse);
                result = paInfoListParse.getResult();
            }
            return result;
        }
        return (List) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PaInfo constructPaInfo(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, cursor)) == null) {
            long j = CursorWrapper.getLong(cursor, "paid");
            String string = CursorWrapper.getString(cursor, "nickname");
            String string2 = CursorWrapper.getString(cursor, "avatar");
            String string3 = CursorWrapper.getString(cursor, "description");
            int i = CursorWrapper.getInt(cursor, "acceptpush");
            String string4 = CursorWrapper.getString(cursor, "url");
            long j2 = CursorWrapper.getLong(cursor, "timestamp");
            String string5 = CursorWrapper.getString(cursor, "detail");
            long j3 = CursorWrapper.getLong(cursor, "tpl");
            int i2 = CursorWrapper.getInt(cursor, "disturb");
            int i3 = CursorWrapper.getInt(cursor, TableDefine.PaSubscribeColumns.COLUMN_SUBTYPE);
            int i4 = CursorWrapper.getInt(cursor, "classtype");
            int i5 = CursorWrapper.getInt(cursor, "classshow");
            String string6 = CursorWrapper.getString(cursor, "classtitle");
            String string7 = CursorWrapper.getString(cursor, "classavatar");
            int i6 = CursorWrapper.getInt(cursor, "marktop");
            long j4 = CursorWrapper.getLong(cursor, "marktoptime");
            int i7 = CursorWrapper.getInt(cursor, "status");
            String string8 = CursorWrapper.getString(cursor, TableDefine.PaSubscribeColumns.COLUMN_REPLIES);
            long j5 = CursorWrapper.getLong(cursor, TableDefine.PaSubscribeColumns.COLUMN_REFRESH_TIME);
            int i8 = CursorWrapper.getInt(cursor, TableDefine.PaSubscribeColumns.COLUMN_SUBSET_TYPE);
            String string9 = CursorWrapper.getString(cursor, TableDefine.PaSubscribeColumns.COLUMN_PA_EXT);
            String string10 = CursorWrapper.getString(cursor, "v_portrait");
            String string11 = CursorWrapper.getString(cursor, "vip_id");
            String string12 = CursorWrapper.getString(cursor, "identity");
            int i9 = CursorWrapper.getInt(cursor, TableDefine.PaSubscribeColumns.COLUMN_HAS_IDENTITY);
            int i10 = CursorWrapper.getInt(cursor, "shield");
            long j6 = CursorWrapper.getLong(cursor, "shield_time");
            int i11 = CursorWrapper.getInt(cursor, TableDefine.PaSubscribeColumns.COLUMN_SUBSCRIBE);
            String string13 = CursorWrapper.getString(cursor, TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT);
            int i12 = CursorWrapper.getInt(cursor, TableDefine.PaSubscribeColumns.COLUMN_REJECT_MENU);
            long j7 = CursorWrapper.getLong(cursor, TableDefine.PaSubscribeColumns.COLUMN_PA_BDUID);
            long j8 = CursorWrapper.getLong(cursor, TableDefine.PaSubscribeColumns.COLUMN_PA_IMUK);
            int i13 = CursorWrapper.getInt(cursor, "business_type");
            int i14 = CursorWrapper.getInt(cursor, TableDefine.PaSubscribeColumns.COLUMN_SHIELD_MSG);
            int i15 = CursorWrapper.getInt(cursor, "map_type");
            String string14 = CursorWrapper.getString(cursor, TableDefine.PaSubscribeColumns.COLUMN_BLOCK_INFO);
            PaInfo paInfo = new PaInfo();
            paInfo.setPaId(j);
            paInfo.setNickName(string);
            paInfo.setAvatar(string2);
            paInfo.setDescription(string3);
            paInfo.setUrl(string4);
            boolean z = true;
            if (i != 1) {
                z = false;
            }
            paInfo.setAcceptPush(z);
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
            paInfo.setRejectMenu(i12);
            paInfo.setImUk(j8);
            paInfo.setBduid(j7);
            paInfo.setBusinessType(i13);
            paInfo.setShieldMsg(i14);
            paInfo.setMapType(i15);
            paInfo.setBlockInfo(string14);
            return paInfo;
        }
        return (PaInfo) invokeL.objValue;
    }

    public long subscribePa(PaInfo paInfo) {
        InterceptResult invokeL;
        long add;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, paInfo)) == null) {
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
            contentValues.put(TableDefine.PaSubscribeColumns.COLUMN_PA_BDUID, Long.valueOf(paInfo.getBduid()));
            contentValues.put(TableDefine.PaSubscribeColumns.COLUMN_PA_IMUK, Long.valueOf(paInfo.getImUk()));
            contentValues.put(TableDefine.PaSubscribeColumns.COLUMN_SHIELD_MSG, Integer.valueOf(paInfo.getShieldMsg()));
            contentValues.put("map_type", Integer.valueOf(paInfo.getMapType()));
            contentValues.put(TableDefine.PaSubscribeColumns.COLUMN_BLOCK_INFO, paInfo.getBlockInfo());
            synchronized (DBBase.mSyncLock) {
                if (!TextUtils.isEmpty(paInfo.getPaExt())) {
                    try {
                        contentValues.put("business_type", Integer.valueOf(new JSONObject(paInfo.getPaExt()).optInt("business_type")));
                    } catch (JSONException unused) {
                    }
                }
                add = add(TableDefine.DB_TABLE_PA_SUBSCRIBE, new String[]{"paid"}, "paid=?", new String[]{String.valueOf(paInfo.getPaId())}, contentValues);
            }
            return add;
        }
        return invokeL.longValue;
    }

    private ChatSession constructShieldUsers(@NonNull ChatSession chatSession, Cursor cursor, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65546, this, chatSession, cursor, z)) == null) {
            chatSession.setContacter(CursorWrapper.getLong(cursor, "paid"));
            chatSession.setNickName(CursorWrapper.getString(cursor, "nickname"));
            chatSession.setIconUrl(CursorWrapper.getString(cursor, "avatar"));
            chatSession.setClassAvatar(CursorWrapper.getString(cursor, "url"));
            chatSession.setExt(CursorWrapper.getString(cursor, TableDefine.PaSubscribeColumns.COLUMN_PA_EXT));
            chatSession.setCertification(CursorWrapper.getString(cursor, "identity"));
            chatSession.setVPortrait(CursorWrapper.getString(cursor, "v_portrait"));
            chatSession.setVipId(CursorWrapper.getString(cursor, "vip_id"));
            if (z) {
                chatSession.setChatType(1);
                chatSession.setShield(CursorWrapper.getInt(cursor, "shield"));
                chatSession.setShieldTime(CursorWrapper.getLong(cursor, "shield_time"));
            }
            return chatSession;
        }
        return (ChatSession) invokeLLZ.objValue;
    }

    private void getPaInfo(@NonNull List<ChatSession> list, @NonNull List<ChatSession> list2, @NonNull IGetUserShieldListener iGetUserShieldListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65549, this, list, list2, iGetUserShieldListener) == null) {
            ArrayList<Long> arrayList = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(Long.valueOf(list.get(i).getContacter()));
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
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
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
                    public void onResult(int i2, String str2, ArrayList<PaInfo> arrayList2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i2, str2, arrayList2) == null) {
                            if (i2 == 0) {
                                if (arrayList2 == null) {
                                    this.val$listener.onResult(-1, "getUser failed", this.val$resultUsers);
                                    return;
                                }
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
                                this.val$listener.onResult(0, DnsModel.MSG_OK, this.val$resultUsers);
                                return;
                            }
                            this.val$listener.onResult(-1, "get paInfo error", this.val$resultUsers);
                        }
                    }
                });
            }
        }
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

    public boolean acceptPaPush(long j, boolean z) {
        InterceptResult invokeCommon;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)})) == null) {
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
        return invokeCommon.booleanValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x0065 */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004c, code lost:
        if (r13 != null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004e, code lost:
        r13.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0060, code lost:
        if (r13 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0064, code lost:
        return r1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [java.lang.CharSequence, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r13v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public PaInfo getPaInfoByThirdId(String str) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            PaInfo paInfo = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                try {
                    if (openDatabase == null) {
                        return null;
                    }
                    try {
                        cursor = openDatabase.query(TableDefine.DB_TABLE_PA_SUBSCRIBE, null, "third_ext LIKE '%\"third_id\":\"" + ((String) str) + "\"%'", null, null, null, null, String.valueOf(1));
                        if (cursor != null) {
                            try {
                                if (cursor.moveToFirst()) {
                                    paInfo = constructPaInfo(cursor);
                                }
                            } catch (Exception e) {
                                e = e;
                                LogUtils.e(TAG, "getPaInfoByThirdId:", e);
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        cursor = null;
                    } catch (Throwable th) {
                        th = th;
                        str = 0;
                        if (str != 0) {
                            str.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } else {
            return (PaInfo) invokeL.objValue;
        }
    }

    public List<PaInfo> getPaInfoListFromDb(List<Long> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            Cursor cursor = null;
            if (list == null || list.size() == 0) {
                return null;
            }
            synchronized (DBBase.mSyncLock) {
                ArrayList arrayList = new ArrayList();
                SQLiteDatabase openDatabase = openDatabase();
                if (openDatabase == null) {
                    return null;
                }
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append(list.get(0));
                    for (int i = 1; i < list.size(); i++) {
                        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                        sb.append(list.get(i));
                    }
                    cursor = openDatabase.query(TableDefine.DB_TABLE_PA_SUBSCRIBE, null, "paid in (" + sb.toString() + ") ", null, null, null, null, null);
                    while (cursor != null) {
                        if (!cursor.moveToNext()) {
                            break;
                        }
                        PaInfo constructPaInfo = constructPaInfo(cursor);
                        if (constructPaInfo != null) {
                            arrayList.add(constructPaInfo);
                        }
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return arrayList;
                } catch (Exception e) {
                    LogUtils.e(TAG, "getPaInfoListFromDb:", e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return arrayList;
                }
            }
        }
        return (List) invokeL.objValue;
    }

    public List<Long> getPaidListByPainfos(SparseArray<List<Integer>> sparseArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, sparseArray)) == null) {
            ArrayList arrayList = new ArrayList();
            if (sparseArray != null && sparseArray.size() > 0) {
                synchronized (DBBase.mSyncLock) {
                    SQLiteDatabase openDatabase = openDatabase();
                    if (openDatabase == null) {
                        return arrayList;
                    }
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < sparseArray.size(); i++) {
                        int keyAt = sparseArray.keyAt(i);
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
                                arrayList.add(Long.valueOf(CursorWrapper.getLong(cursor, "paid")));
                            }
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        return arrayList;
                    } catch (Exception e) {
                        LogUtils.e(TAG, "getPaidListByPainfos:", e);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return arrayList;
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x011f, code lost:
        if (r4 != null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0121, code lost:
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x013a, code lost:
        if (r4 != null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x013e, code lost:
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0143 A[Catch: all -> 0x0147, TryCatch #4 {, blocks: (B:6:0x000d, B:8:0x001a, B:9:0x001f, B:42:0x0121, B:53:0x013d, B:58:0x0143, B:59:0x0146), top: B:66:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void getShieldUserByPaId(@NonNull List<ChatSession> list, boolean z, @NonNull IGetUserShieldListener iGetUserShieldListener) {
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{list, Boolean.valueOf(z), iGetUserShieldListener}) == null) {
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                ArrayList arrayList = new ArrayList();
                Cursor cursor2 = null;
                if (openDatabase == null) {
                    iGetUserShieldListener.onResult(-1, "db failed", null);
                    return;
                }
                try {
                    String str = "";
                    if (list.size() > 0) {
                        try {
                            String str2 = "" + list.get(0).getContacter();
                            for (int i = 1; i < list.size(); i++) {
                                str2 = str2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + list.get(i).getContacter();
                            }
                            str = "paid in (" + str2 + ") ";
                        } catch (Exception e) {
                            e = e;
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
                                long j = CursorWrapper.getLong(cursor, "paid");
                                ChatSession chatSession = new ChatSession();
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= list.size()) {
                                        break;
                                    } else if (list.get(i2).getContacter() == j) {
                                        chatSession = list.get(i2);
                                        break;
                                    } else {
                                        i2++;
                                    }
                                }
                                list.remove(chatSession);
                                arrayList.add(constructShieldUsers(chatSession, cursor, false));
                            } catch (Exception e2) {
                                e = e2;
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
                    if (list.size() <= 0) {
                        iGetUserShieldListener.onResult(0, DnsModel.MSG_OK, arrayList);
                    } else {
                        getPaInfo(list, arrayList, iGetUserShieldListener);
                    }
                } catch (Exception e3) {
                    e = e3;
                    cursor = null;
                } catch (Throwable th3) {
                    th = th3;
                    cursor2 = null;
                }
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
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
                        for (int i = 1; i < list.size(); i++) {
                            str2 = str2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + list.get(i);
                        }
                        str = "shield = ? AND pasubtype in (" + str2 + ") ";
                    }
                    String str3 = str;
                    cursor = openDatabase.query(TableDefine.DB_TABLE_PA_SUBSCRIBE, null, str3, new String[]{String.valueOf(1)}, null, null, null, null);
                    while (cursor != null && cursor.moveToNext()) {
                        arrayList.add(constructShieldUsers(new ChatSession(), cursor, true));
                    }
                    LogUtils.e(TAG, "whereClause :" + str3 + ", users :" + arrayList.size());
                } catch (Exception e) {
                    LogUtils.e(TAG, "getShieldUser:", e);
                }
            }
        } else {
            return (List) invokeL.objValue;
        }
    }

    public boolean isSubscribed(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) {
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
                } catch (Exception e) {
                    LogUtils.e(LogUtils.TAG, "isSubscribed:", e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return false;
                }
            }
        }
        return invokeJ.booleanValue;
    }

    public ArrayList<Long> queryPaIdByPaType(int i) {
        InterceptResult invokeI;
        ArrayList<Long> result;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            PaidParse paidParse = new PaidParse(this);
            synchronized (DBBase.mSyncLock) {
                query(TableDefine.DB_TABLE_PA_SUBSCRIBE, new String[]{"paid"}, "pasubtype = ?", new String[]{Integer.toString(i)}, null, null, null, paidParse);
                result = paidParse.getResult();
            }
            return result;
        }
        return (ArrayList) invokeI.objValue;
    }

    public PaInfo queryPaInfo(long j) {
        InterceptResult invokeJ;
        PaInfo result;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j)) == null) {
            PaInfoParse paInfoParse = new PaInfoParse(this);
            synchronized (DBBase.mSyncLock) {
                query(TableDefine.DB_TABLE_PA_SUBSCRIBE, null, "paid = ?", new String[]{Long.toString(j)}, null, null, null, paInfoParse);
                result = paInfoParse.getResult();
            }
            return result;
        }
        return (PaInfo) invokeJ.objValue;
    }

    public List<PaInfo> queryPaInfoByChatType(int i) {
        InterceptResult invokeI;
        List<PaInfo> result;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            PaInfoListParse paInfoListParse = new PaInfoListParse(this);
            synchronized (DBBase.mSyncLock) {
                query(TableDefine.DB_TABLE_PA_SUBSCRIBE, null, "pasubtype=?", new String[]{Integer.toString(i)}, null, null, null, paInfoListParse);
                result = paInfoListParse.getResult();
            }
            return result;
        }
        return (List) invokeI.objValue;
    }

    public List<PaInfo> queryPaInfoByExt(String str) {
        InterceptResult invokeL;
        List<PaInfo> result;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            PaInfoListParse paInfoListParse = new PaInfoListParse(this);
            synchronized (DBBase.mSyncLock) {
                query(TableDefine.DB_TABLE_PA_SUBSCRIBE, null, "business_type = ?", new String[]{str}, null, null, null, paInfoListParse);
                result = paInfoListParse.getResult();
            }
            return result;
        }
        return (List) invokeL.objValue;
    }

    public int unSubscribePa(long j) {
        InterceptResult invokeJ;
        int delete;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048592, this, j)) == null) {
            if (j < 0) {
                return -1;
            }
            synchronized (DBBase.mSyncLock) {
                delete = delete(TableDefine.DB_TABLE_PA_SUBSCRIBE, "paid=?", new String[]{String.valueOf(j)});
            }
            return delete;
        }
        return invokeJ.intValue;
    }

    public ArrayList<Long> queryPaidList() {
        InterceptResult invokeV;
        ArrayList<Long> result;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            PaidParse paidParse = new PaidParse(this);
            synchronized (DBBase.mSyncLock) {
                query(TableDefine.DB_TABLE_PA_SUBSCRIBE, new String[]{"paid"}, null, null, null, null, null, paidParse);
                result = paidParse.getResult();
            }
            return result;
        }
        return (ArrayList) invokeV.objValue;
    }

    public int setPaQuickRelies(long j, String str, long j2) {
        InterceptResult invokeCommon;
        int update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Long.valueOf(j), str, Long.valueOf(j2)})) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(TableDefine.PaSubscribeColumns.COLUMN_REPLIES, str);
            contentValues.put(TableDefine.PaSubscribeColumns.COLUMN_REFRESH_TIME, Long.valueOf(j2));
            synchronized (DBBase.mSyncLock) {
                update = update(TableDefine.DB_TABLE_PA_SUBSCRIBE, "paid=?", new String[]{String.valueOf(j)}, contentValues);
            }
            return update;
        }
        return invokeCommon.intValue;
    }

    public boolean updateMarkTop(long j, int i, long j2) {
        InterceptResult invokeCommon;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2)})) == null) {
            String str = TAG;
            LogUtils.d(str, "updateMarkTop, paid=" + j + ", markToped=" + i + ", updateTime=" + j2);
            ContentValues contentValues = new ContentValues();
            contentValues.put("marktop", Integer.valueOf(i));
            contentValues.put("marktoptime", Long.valueOf(j2));
            synchronized (DBBase.mSyncLock) {
                z = true;
                if (update(TableDefine.DB_TABLE_PA_SUBSCRIBE, "paid =? ", new String[]{String.valueOf(j)}, contentValues) > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                int updateChatSessionMarkTop = ChatMessageDBManager.getInstance(this.mContext).updateChatSessionMarkTop(0, j, i, j2);
                if (!z2 && updateChatSessionMarkTop <= 0) {
                    z = false;
                }
            }
            return z;
        }
        return invokeCommon.booleanValue;
    }

    public boolean updateShield(@NonNull ChatSession chatSession, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        boolean z3;
        boolean z4;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{chatSession, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            ContentValues contentValues = new ContentValues();
            if (z2) {
                contentValues.put("shield", Integer.valueOf(chatSession.getShield()));
                contentValues.put("shield_time", Long.valueOf(chatSession.getShieldTime()));
                if (!TextUtils.isEmpty(chatSession.getShieldTypes())) {
                    contentValues.put(TableDefine.PaSubscribeColumns.COLUMN_BLOCK_INFO, chatSession.getShieldTypes());
                }
            }
            if (z) {
                contentValues.put("marktop", Integer.valueOf(chatSession.getMarkTop()));
                contentValues.put("marktoptime", Long.valueOf(chatSession.getMarkTopTime()));
            }
            synchronized (DBBase.mSyncLock) {
                long contacter = chatSession.getContacter();
                z3 = true;
                if (update(TableDefine.DB_TABLE_PA_SUBSCRIBE, "paid=?", new String[]{String.valueOf(contacter)}, contentValues) > 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                int updateChatSessionShield = ChatMessageDBManager.getInstance(this.mContext).updateChatSessionShield(0, contacter, chatSession.getShield(), chatSession.getShieldTime());
                MediaMessageDBManager.getInstance(this.mContext).updateChatSessionShield(0, contacter, chatSession.getShield(), chatSession.getShieldTime());
                if (z) {
                    i = ChatMessageDBManager.getInstance(this.mContext).updateChatSessionMarkTop(0, contacter, chatSession.getMarkTop(), chatSession.getMarkTopTime());
                } else {
                    i = 0;
                }
                if (!z4 && updateChatSessionShield <= 0 && i <= 0) {
                    z3 = false;
                }
            }
            return z3;
        }
        return invokeCommon.booleanValue;
    }

    public boolean updateSubscribedUser(long j, int i) {
        InterceptResult invokeCommon;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048598, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)})) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(TableDefine.PaSubscribeColumns.COLUMN_SUBSCRIBE, Integer.valueOf(i));
            synchronized (DBBase.mSyncLock) {
                int i2 = 1;
                if (update(TableDefine.DB_TABLE_PA_SUBSCRIBE, "paid =? ", new String[]{String.valueOf(j)}, contentValues) > 0) {
                    z = true;
                } else {
                    z = false;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(Long.valueOf(j));
                List<PaInfo> paInfoListFromDb = getPaInfoListFromDb(arrayList);
                if (paInfoListFromDb != null && paInfoListFromDb.size() != 0) {
                    PaInfo paInfo = paInfoListFromDb.get(0);
                    if (paInfo.getHasIdentity() == 0 && (paInfo.getSubscribe() == 0 || paInfo.getSubscribe() == 2)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        i2 = 0;
                    }
                    ChatMessageDBManager.getInstance(this.mContext).updateSessionStranger(0, paInfo.getPaId(), i2);
                    MediaMessageDBManager.getInstance(this.mContext).updateSessionStranger(0, paInfo.getPaId(), i2);
                    return z;
                }
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }
}
