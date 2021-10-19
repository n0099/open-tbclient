package c.a.r0.n1;

import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.resourceLoaderProc.BigImageLoaderProc;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.tieba.recapp.report.AdUploadHttpRequest;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public boolean B;
    public boolean C;
    public String D;
    public String E;
    public int F;
    public String G;
    public String H;
    public String I;
    public String J;
    public String K;
    public int L;
    public MetaData M;
    public String N;
    public boolean O;
    public ForumData P;
    public int Q;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<String> f22363a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, String> f22364b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, ImageUrlData> f22365c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<AlaInfoData> f22366d;

    /* renamed from: e  reason: collision with root package name */
    public String f22367e;

    /* renamed from: f  reason: collision with root package name */
    public String f22368f;

    /* renamed from: g  reason: collision with root package name */
    public String f22369g;

    /* renamed from: h  reason: collision with root package name */
    public String f22370h;

    /* renamed from: i  reason: collision with root package name */
    public String f22371i;

    /* renamed from: j  reason: collision with root package name */
    public String f22372j;
    public String k;
    public boolean l;
    public boolean m;
    public a n;
    public int o;
    public boolean p;
    public boolean q;
    public InterfaceC1046b r;
    public AdvertAppInfo s;
    public String t;
    public String u;
    public int v;
    public boolean w;
    public String x;
    public String y;
    public boolean z;

    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f22373a;

        /* renamed from: b  reason: collision with root package name */
        public String f22374b;

        /* renamed from: c  reason: collision with root package name */
        public String f22375c;

        /* renamed from: d  reason: collision with root package name */
        public int f22376d;

        /* renamed from: e  reason: collision with root package name */
        public int f22377e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f22378f;

        public a(b bVar, String str, String str2, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, str2, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22378f = bVar;
            this.f22373a = null;
            this.f22374b = null;
            this.f22375c = null;
            this.f22376d = 0;
            this.f22377e = 0;
            this.f22375c = str2;
            this.f22374b = str;
            this.f22376d = i2;
            this.f22377e = i3;
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22373a.addPostData("forum_id", this.f22378f.f22370h);
                this.f22373a.addPostData("user_id", this.f22378f.t == null ? "0" : this.f22378f.t);
                this.f22373a.addPostData(TiebaStatic.Params.SAMPLE_ID, TbSingleton.getInstance().getSampleId());
                this.f22373a.addPostData("scr_w", String.valueOf(l.k(TbadkCoreApplication.getInst().getApp())));
                this.f22373a.addPostData("scr_h", String.valueOf(l.i(TbadkCoreApplication.getInst().getApp())));
                this.f22373a.addPostData("q_type", String.valueOf(TbImageHelper.getInstance().isShowBigImage() ? 2 : 1));
                this.f22373a.addPostData(AdUploadHttpRequest.KEY_OS_VERSION, Build.VERSION.RELEASE);
                this.f22373a.addPostData("page_name", "PB");
                this.f22373a.addPostData("pic_index", String.valueOf(this.f22378f.f22363a.size()));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public e doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, objArr)) == null) {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.IMAGE_PB_ADDRESS);
                this.f22373a = netWork;
                netWork.addPostData(TiebaStatic.Params.H5_FORUM_NAME, this.f22378f.f22371i);
                this.f22373a.addPostData("tid", this.f22374b);
                String str = this.f22375c;
                if (str != null) {
                    this.f22373a.addPostData(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, str);
                }
                if (!TextUtils.isEmpty(this.f22378f.f22367e) && !"0".equals(this.f22378f.f22367e)) {
                    this.f22373a.addPostData("post_id", this.f22378f.f22367e);
                }
                this.f22373a.addPostData("source", String.valueOf(this.f22378f.q ? 1 : 2));
                this.f22378f.q = false;
                this.f22373a.addPostData(UnitedSchemeConstants.UNITED_SCHEME_NEXT, String.valueOf(this.f22376d));
                this.f22373a.addPostData("prev", String.valueOf(this.f22377e));
                this.f22373a.addPostData("not_see_lz", String.valueOf(!this.f22378f.p ? 1 : 0));
                this.f22373a.addPostData("is_top_agree", String.valueOf(this.f22378f.B ? 1 : 2));
                if (!this.f22378f.m) {
                    this.f22373a.addPostData(r.f42346a, String.valueOf(1));
                }
                if (!StringUtils.isNull(this.f22378f.u, true)) {
                    this.f22373a.addPostData("obj_type", this.f22378f.u);
                } else {
                    this.f22373a.addPostData("obj_type", "other");
                }
                if (TextUtils.isEmpty(this.f22378f.x)) {
                    if (System.currentTimeMillis() - c.a.q0.s.d0.b.j().l("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                        this.f22378f.x = c.a.q0.s.d0.b.j().p("applist_intalled_apk_ids", "");
                    }
                }
                this.f22373a.addPostData("applist", this.f22378f.x);
                String lastCachedOid = PermissionUtil.getLastCachedOid(TbadkCoreApplication.getInst());
                if (!TextUtils.isEmpty(lastCachedOid)) {
                    this.f22373a.addPostData("oaid", lastCachedOid);
                }
                this.f22373a.addPostData("app_transmit_data", c.a.q0.d1.g.a());
                this.f22373a.addPostData("ad_ext_params", AdExtParam.a.b().a());
                b();
                this.f22373a.getNetContext().getRequest().mNeedBackgroundLogin = false;
                String postNetData = this.f22373a.postNetData();
                if (this.f22373a.getNetContext().getResponse().isRequestSuccess()) {
                    e eVar = new e();
                    eVar.l(postNetData, true);
                    return eVar;
                }
                return null;
            }
            return (e) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                NetWork netWork = this.f22373a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.f22378f.n = null;
                super.cancel(true);
            }
        }

        public String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f22375c : (String) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r8v45, resolved type: com.baidu.tbadk.coreExtra.view.ImageUrlData */
        /* JADX DEBUG: Multi-variable search result rejected for r8v46, resolved type: com.baidu.tbadk.coreExtra.view.ImageUrlData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public void onPostExecute(e eVar) {
            ImageUrlData imageUrlData;
            boolean z;
            int i2;
            boolean z2;
            AgreeData agreeData;
            String str;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) {
                super.onPostExecute(eVar);
                if (this.f22378f.f22365c == null) {
                    return;
                }
                String str2 = null;
                this.f22378f.n = null;
                if (eVar == null) {
                    if (this.f22378f.r != null) {
                        NetWork netWork = this.f22373a;
                        if (netWork != null) {
                            i3 = netWork.getServerErrorCode();
                            if (this.f22375c == null) {
                                str2 = this.f22373a.getErrorString();
                            }
                        } else {
                            i3 = -1;
                        }
                        this.f22378f.r.b(i3, str2);
                        return;
                    }
                    return;
                }
                boolean isEmpty = ListUtils.isEmpty(eVar.g());
                if (this.f22378f.z && !isEmpty) {
                    this.f22378f.f22363a.clear();
                    this.f22378f.f22365c.clear();
                    this.f22378f.f22364b.clear();
                }
                if (eVar.h() != 0) {
                    this.f22378f.o = eVar.h();
                }
                this.f22378f.s = eVar.a();
                this.f22378f.Q = eVar.m;
                b bVar = this.f22378f;
                bVar.K = eVar.f22397i;
                bVar.L = eVar.i();
                b bVar2 = this.f22378f;
                bVar2.M = eVar.k;
                bVar2.N = eVar.f22398j;
                bVar2.O = eVar.l == 1;
                if (this.f22375c == null) {
                    this.f22378f.f22363a.clear();
                    this.f22378f.f22364b.clear();
                }
                LinkedList<c> g2 = eVar.g();
                int size = g2.size();
                if (size <= 0) {
                    imageUrlData = null;
                    z = isEmpty;
                    this.f22378f.l = true;
                } else {
                    int i4 = 0;
                    while (i4 < size) {
                        c cVar = g2.get(i4);
                        String S = this.f22378f.S(cVar);
                        ImageUrlData imageUrlData2 = new ImageUrlData();
                        String f2 = cVar.f();
                        imageUrlData2.id = f2;
                        if (StringHelper.equals(f2, this.f22378f.A)) {
                            imageUrlData2.setSourceImageRectInScreen(this.f22378f.y);
                        }
                        imageUrlData2.imageUrl = S;
                        String str3 = S + "*" + cVar.k();
                        imageUrlData2.mWidth = cVar.r();
                        imageUrlData2.mHeigth = cVar.e();
                        imageUrlData2.urlType = 10;
                        imageUrlData2.originalUrl = cVar.i();
                        boolean z3 = isEmpty;
                        imageUrlData2.originalSize = cVar.j();
                        imageUrlData2.forumId = this.f22378f.f22370h;
                        imageUrlData2.forumName = this.f22378f.f22371i;
                        imageUrlData2.threadId = c.a.e.e.m.b.g(this.f22374b, -1L);
                        imageUrlData2.nid = this.f22378f.f22369g;
                        imageUrlData2.postId = c.a.e.e.m.b.g(cVar.c(), -1L);
                        imageUrlData2.userId = cVar.o();
                        imageUrlData2.userNameShow = StringUtils.isNull(cVar.q()) ? cVar.p() : cVar.q();
                        imageUrlData2.mIsReserver = this.f22378f.m;
                        imageUrlData2.mIsSeeHost = this.f22378f.p;
                        imageUrlData2.overAllIndex = cVar.k();
                        imageUrlData2.mThreadType = this.f22378f.v;
                        imageUrlData2.mPicType = cVar.l();
                        imageUrlData2.mTagName = cVar.n();
                        imageUrlData2.mIsShowOrigonButton = cVar.v();
                        imageUrlData2.isLongPic = cVar.u();
                        imageUrlData2.isBlockedPic = cVar.s();
                        imageUrlData2.from = this.f22378f.u;
                        if (cVar.m() != null) {
                            imageUrlData2.richTextArray = cVar.m().toString();
                        }
                        imageUrlData2.isFirstPost = cVar.t();
                        if (cVar.a() != null) {
                            AgreeData a2 = cVar.a();
                            imageUrlData2.agreeData = a2;
                            a2.isFromImageViewer = true;
                            a2.mImageViewerFromPage = this.f22378f.u;
                            imageUrlData2.agreeData.forumId = this.f22378f.f22370h;
                            imageUrlData2.agreeData.threadId = String.valueOf(imageUrlData2.threadId);
                            AgreeData agreeData2 = imageUrlData2.agreeData;
                            agreeData2.nid = imageUrlData2.nid;
                            agreeData2.postId = String.valueOf(imageUrlData2.postId);
                            imageUrlData2.agreeData.indexOfPic = imageUrlData2.overAllIndex;
                            imageUrlData2.commentNum = cVar.d();
                            if (cVar.t()) {
                                AgreeData agreeData3 = imageUrlData2.agreeData;
                                agreeData3.objType = 3;
                                agreeData3.isInThread = true;
                                agreeData3.isInPost = false;
                            } else {
                                AgreeData agreeData4 = imageUrlData2.agreeData;
                                agreeData4.objType = 1;
                                agreeData4.isInThread = false;
                                agreeData4.isInPost = true;
                            }
                            imageUrlData2.agreeData.cardType = this.f22378f.F;
                            imageUrlData2.agreeData.recomSource = this.f22378f.G;
                            imageUrlData2.agreeData.recomAbTag = this.f22378f.H;
                            imageUrlData2.agreeData.recomExtra = this.f22378f.J;
                            imageUrlData2.agreeData.recomWeight = this.f22378f.I;
                        }
                        if (this.f22378f.f22364b.containsKey(imageUrlData2.id)) {
                            String str4 = (String) this.f22378f.f22364b.get(imageUrlData2.id);
                            ImageUrlData imageUrlData3 = (ImageUrlData) this.f22378f.f22365c.get(str4);
                            if (imageUrlData3 == null) {
                                this.f22378f.f22365c.put(str4, imageUrlData2);
                            } else {
                                imageUrlData3.imageUrl = imageUrlData2.imageUrl;
                                imageUrlData3.overAllIndex = imageUrlData2.overAllIndex;
                                imageUrlData3.mIsShowOrigonButton = imageUrlData2.mIsShowOrigonButton;
                                imageUrlData3.isLongPic = imageUrlData2.isLongPic;
                                imageUrlData3.richTextArray = imageUrlData2.richTextArray;
                                imageUrlData3.commentNum = imageUrlData2.commentNum;
                                imageUrlData3.agreeData = imageUrlData2.agreeData;
                                imageUrlData3.isFirstPost = imageUrlData2.isFirstPost;
                                imageUrlData3.userId = imageUrlData2.userId;
                                imageUrlData3.userNameShow = imageUrlData2.userNameShow;
                                imageUrlData3.forumId = this.f22378f.f22370h;
                                imageUrlData3.forumName = this.f22378f.f22371i;
                                imageUrlData3.mHeigth = imageUrlData2.mHeigth;
                                imageUrlData3.mWidth = imageUrlData2.mWidth;
                                if (StringHelper.equals(imageUrlData2.id, this.f22378f.A)) {
                                    imageUrlData3.setSourceImageRectInScreen(this.f22378f.y);
                                }
                            }
                            str = null;
                        } else if (!this.f22378f.C) {
                            str = null;
                            this.f22378f.f22365c.put(str3, imageUrlData2);
                            if (this.f22378f.w) {
                                this.f22378f.f22363a.add(i4, str3);
                            } else {
                                this.f22378f.f22363a.add(str3);
                            }
                            this.f22378f.f22364b.put(imageUrlData2.id, str3);
                        } else {
                            b bVar3 = this.f22378f;
                            bVar3.o = bVar3.f22365c.size();
                            str = null;
                            this.f22378f.s = null;
                        }
                        i4++;
                        isEmpty = z3;
                        str2 = str;
                    }
                    String str5 = str2;
                    z = isEmpty;
                    c cVar2 = (c) ListUtils.getItem(g2, 0);
                    if (cVar2 != null) {
                        this.f22378f.f22372j = cVar2.f();
                    }
                    c cVar3 = (c) ListUtils.getItem(g2, size - 1);
                    imageUrlData = str5;
                    if (cVar3 != null) {
                        this.f22378f.k = cVar3.f();
                        b bVar4 = this.f22378f;
                        bVar4.l = ((long) bVar4.o) == cVar3.k();
                        imageUrlData = str5;
                    }
                }
                for (ImageUrlData imageUrlData4 : this.f22378f.f22365c.values()) {
                    if (imageUrlData4.agreeData == null) {
                        long j2 = imageUrlData4.postId;
                        if (imageUrlData == null) {
                            for (ImageUrlData imageUrlData5 : this.f22378f.f22365c.values()) {
                                if (imageUrlData5.postId == j2 && (agreeData = imageUrlData5.agreeData) != null) {
                                    imageUrlData4.agreeData = agreeData;
                                    imageUrlData4.richTextArray = imageUrlData5.richTextArray;
                                    imageUrlData4.commentNum = imageUrlData5.commentNum;
                                    imageUrlData4.userId = imageUrlData5.userId;
                                    imageUrlData4.userNameShow = imageUrlData5.userNameShow;
                                    imageUrlData4.forumId = this.f22378f.f22370h;
                                    imageUrlData4.forumName = this.f22378f.f22371i;
                                    imageUrlData = imageUrlData5;
                                }
                            }
                        } else if (j2 == imageUrlData.postId) {
                            imageUrlData4.agreeData = imageUrlData.agreeData;
                            imageUrlData4.richTextArray = imageUrlData.richTextArray;
                            imageUrlData4.commentNum = imageUrlData.commentNum;
                            imageUrlData4.userId = imageUrlData.userId;
                            imageUrlData4.userNameShow = imageUrlData.userNameShow;
                            imageUrlData4.forumId = this.f22378f.f22370h;
                            imageUrlData4.forumName = this.f22378f.f22371i;
                        }
                    }
                }
                if (this.f22375c == null) {
                    this.f22378f.f22368f = this.f22374b;
                    i2 = 0;
                    z2 = true;
                } else {
                    i2 = -1;
                    z2 = false;
                }
                int position = this.f22378f.w ? ListUtils.getPosition(this.f22378f.f22363a, (String) this.f22378f.f22364b.get(this.f22375c)) - 1 : i2;
                this.f22378f.D = eVar.e();
                this.f22378f.E = eVar.j();
                this.f22378f.P = eVar.f();
                if (this.f22378f.f22366d == null) {
                    this.f22378f.f22366d = new ArrayList();
                    if (eVar.d() != null && eVar.g().size() > 0) {
                        this.f22378f.f22366d.addAll(eVar.d());
                    }
                }
                if (this.f22378f.r != null) {
                    this.f22378f.r.a(this.f22378f.f22363a, position, this.f22378f.o, false, null, z2, this.f22378f.s, z);
                }
                this.f22378f.z = false;
            }
        }
    }

    /* renamed from: c.a.r0.n1.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1046b {
        void a(ArrayList<String> arrayList, int i2, int i3, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);

        void b(int i2, String str);
    }

    public b(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2, boolean z, int i3, String str8, String str9, String str10, String str11) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {arrayList, map, str, str2, str3, str4, str5, str6, str7, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), str8, str9, str10, str11};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22364b = new HashMap<>();
        this.l = false;
        this.m = true;
        this.n = null;
        this.o = 0;
        this.p = false;
        this.q = false;
        this.r = null;
        this.s = null;
        this.w = false;
        this.C = false;
        this.f22363a = arrayList;
        this.f22365c = map;
        if (arrayList == null) {
            this.f22363a = new ArrayList<>();
        }
        Iterator<String> it = this.f22363a.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.f22364b.put(c.a.r0.n1.a.a(next), next);
        }
        this.f22368f = str3;
        this.f22369g = str4;
        this.f22371i = str2;
        this.f22370h = str;
        this.k = str5;
        this.v = i2;
        this.l = str5 == null;
        this.t = str6;
        this.u = str7;
        this.z = z;
        this.B = false;
        this.F = i3;
        this.G = str8;
        this.H = str9;
        this.I = str10;
        this.J = str11;
    }

    public final String S(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            if (cVar.b() != null && cVar.b().length() > 0) {
                return cVar.b();
            }
            StringBuilder sb = new StringBuilder(150);
            int threadImageMaxWidth = TbConfig.getThreadImageMaxWidth();
            int i2 = threadImageMaxWidth * threadImageMaxWidth;
            if (cVar.e() * cVar.r() > i2) {
                double sqrt = Math.sqrt(i2 / (cVar.e() * cVar.r()));
                sb.append(BigImageLoaderProc.NCDN_PER);
                sb.append(String.valueOf((int) (cVar.r() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (cVar.e() * sqrt)));
            } else {
                sb.append(BigImageLoaderProc.NCDN_PER);
                sb.append(String.valueOf(cVar.r()));
                sb.append("&height=");
                sb.append(String.valueOf(cVar.e()));
            }
            sb.append("&src=");
            sb.append(k.getUrlEncode(cVar.g()));
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public ArrayList<AlaInfoData> T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f22366d : (ArrayList) invokeV.objValue;
    }

    public String U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.D : (String) invokeV.objValue;
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.w = false;
            if (this.l) {
                return;
            }
            i0(this.f22368f, this.k, 10, 0);
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.w = true;
            String str = this.f22363a.get(0);
            if (StringUtils.isNull(this.f22372j)) {
                this.f22372j = c.a.r0.n1.a.a(str);
            }
            i0(this.f22368f, this.f22372j, 0, 10);
        }
    }

    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.E : (String) invokeV.objValue;
    }

    public int Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.Q : invokeV.intValue;
    }

    public void Z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.A = str;
        }
    }

    public void a0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.q = z;
        }
    }

    public void b0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.C = z;
        }
    }

    public void c0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.B = z;
        }
    }

    public void d0(InterfaceC1046b interfaceC1046b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, interfaceC1046b) == null) {
            this.r = interfaceC1046b;
        }
    }

    public void e0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.f22367e = str;
        }
    }

    public void f0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.m = z;
        }
    }

    public void g0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.p = z;
        }
    }

    public void h0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.y = str;
        }
    }

    public final void i0(String str, String str2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048592, this, str, str2, i2, i3) == null) {
            a aVar = this.n;
            if (aVar != null) {
                if (str2 != null && str2.equals(aVar.d())) {
                    return;
                }
                this.n.cancel();
            }
            a aVar2 = new a(this, str, str2, i2, i3);
            this.n = aVar2;
            aVar2.setPriority(3);
            this.n.execute(new Object[0]);
        }
    }
}
