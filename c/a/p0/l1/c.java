package c.a.p0.l1;

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
public class c {
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
    public ArrayList<String> f21279a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, String> f21280b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, ImageUrlData> f21281c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<AlaInfoData> f21282d;

    /* renamed from: e  reason: collision with root package name */
    public String f21283e;

    /* renamed from: f  reason: collision with root package name */
    public String f21284f;

    /* renamed from: g  reason: collision with root package name */
    public String f21285g;

    /* renamed from: h  reason: collision with root package name */
    public String f21286h;

    /* renamed from: i  reason: collision with root package name */
    public String f21287i;

    /* renamed from: j  reason: collision with root package name */
    public String f21288j;
    public String k;
    public boolean l;
    public boolean m;
    public a n;
    public int o;
    public boolean p;
    public boolean q;
    public b r;
    public AdvertAppInfo s;
    public String t;
    public String u;
    public int v;
    public boolean w;
    public String x;
    public String y;
    public boolean z;

    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f21289a;

        /* renamed from: b  reason: collision with root package name */
        public String f21290b;

        /* renamed from: c  reason: collision with root package name */
        public String f21291c;

        /* renamed from: d  reason: collision with root package name */
        public int f21292d;

        /* renamed from: e  reason: collision with root package name */
        public int f21293e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f21294f;

        public a(c cVar, String str, String str2, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str, str2, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21294f = cVar;
            this.f21289a = null;
            this.f21290b = null;
            this.f21291c = null;
            this.f21292d = 0;
            this.f21293e = 0;
            this.f21291c = str2;
            this.f21290b = str;
            this.f21292d = i2;
            this.f21293e = i3;
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21289a.addPostData("forum_id", this.f21294f.f21286h);
                this.f21289a.addPostData("user_id", this.f21294f.t == null ? "0" : this.f21294f.t);
                this.f21289a.addPostData(TiebaStatic.Params.SAMPLE_ID, TbSingleton.getInstance().getSampleId());
                this.f21289a.addPostData("scr_w", String.valueOf(l.k(TbadkCoreApplication.getInst().getApp())));
                this.f21289a.addPostData("scr_h", String.valueOf(l.i(TbadkCoreApplication.getInst().getApp())));
                this.f21289a.addPostData("q_type", String.valueOf(TbImageHelper.getInstance().isShowBigImage() ? 2 : 1));
                this.f21289a.addPostData(AdUploadHttpRequest.KEY_OS_VERSION, Build.VERSION.RELEASE);
                this.f21289a.addPostData("page_name", "PB");
                this.f21289a.addPostData("pic_index", String.valueOf(this.f21294f.f21279a.size()));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public f doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, objArr)) == null) {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.IMAGE_PB_ADDRESS);
                this.f21289a = netWork;
                netWork.addPostData(TiebaStatic.Params.H5_FORUM_NAME, this.f21294f.f21287i);
                this.f21289a.addPostData("tid", this.f21290b);
                String str = this.f21291c;
                if (str != null) {
                    this.f21289a.addPostData(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, str);
                }
                if (!TextUtils.isEmpty(this.f21294f.f21283e) && !"0".equals(this.f21294f.f21283e)) {
                    this.f21289a.addPostData("post_id", this.f21294f.f21283e);
                }
                this.f21289a.addPostData("source", String.valueOf(this.f21294f.q ? 1 : 2));
                this.f21294f.q = false;
                this.f21289a.addPostData(UnitedSchemeConstants.UNITED_SCHEME_NEXT, String.valueOf(this.f21292d));
                this.f21289a.addPostData("prev", String.valueOf(this.f21293e));
                this.f21289a.addPostData("not_see_lz", String.valueOf(!this.f21294f.p ? 1 : 0));
                this.f21289a.addPostData("is_top_agree", String.valueOf(this.f21294f.B ? 1 : 2));
                if (!this.f21294f.m) {
                    this.f21289a.addPostData(r.f42062a, String.valueOf(1));
                }
                if (!StringUtils.isNull(this.f21294f.u, true)) {
                    this.f21289a.addPostData("obj_type", this.f21294f.u);
                } else {
                    this.f21289a.addPostData("obj_type", "other");
                }
                if (TextUtils.isEmpty(this.f21294f.x)) {
                    if (System.currentTimeMillis() - c.a.o0.s.d0.b.j().l("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                        this.f21294f.x = c.a.o0.s.d0.b.j().p("applist_intalled_apk_ids", "");
                    }
                }
                this.f21289a.addPostData("applist", this.f21294f.x);
                String lastCachedOid = PermissionUtil.getLastCachedOid(TbadkCoreApplication.getInst());
                if (!TextUtils.isEmpty(lastCachedOid)) {
                    this.f21289a.addPostData("oaid", lastCachedOid);
                }
                this.f21289a.addPostData("ad_ext_params", AdExtParam.a.b().a());
                b();
                this.f21289a.getNetContext().getRequest().mNeedBackgroundLogin = false;
                String postNetData = this.f21289a.postNetData();
                if (this.f21289a.getNetContext().getResponse().isRequestSuccess()) {
                    f fVar = new f();
                    fVar.l(postNetData, true);
                    return fVar;
                }
                return null;
            }
            return (f) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                NetWork netWork = this.f21289a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.f21294f.n = null;
                super.cancel(true);
            }
        }

        public String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f21291c : (String) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r8v45, resolved type: com.baidu.tbadk.coreExtra.view.ImageUrlData */
        /* JADX DEBUG: Multi-variable search result rejected for r8v46, resolved type: com.baidu.tbadk.coreExtra.view.ImageUrlData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public void onPostExecute(f fVar) {
            ImageUrlData imageUrlData;
            boolean z;
            int i2;
            boolean z2;
            AgreeData agreeData;
            String str;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
                super.onPostExecute(fVar);
                if (this.f21294f.f21281c == null) {
                    return;
                }
                String str2 = null;
                this.f21294f.n = null;
                if (fVar == null) {
                    if (this.f21294f.r != null) {
                        NetWork netWork = this.f21289a;
                        if (netWork != null) {
                            i3 = netWork.getServerErrorCode();
                            if (this.f21291c == null) {
                                str2 = this.f21289a.getErrorString();
                            }
                        } else {
                            i3 = -1;
                        }
                        this.f21294f.r.b(i3, str2);
                        return;
                    }
                    return;
                }
                boolean isEmpty = ListUtils.isEmpty(fVar.g());
                if (this.f21294f.z && !isEmpty) {
                    this.f21294f.f21279a.clear();
                    this.f21294f.f21281c.clear();
                    this.f21294f.f21280b.clear();
                }
                if (fVar.h() != 0) {
                    this.f21294f.o = fVar.h();
                }
                this.f21294f.s = fVar.a();
                this.f21294f.Q = fVar.m;
                c cVar = this.f21294f;
                cVar.K = fVar.f21313i;
                cVar.L = fVar.i();
                c cVar2 = this.f21294f;
                cVar2.M = fVar.k;
                cVar2.N = fVar.f21314j;
                cVar2.O = fVar.l == 1;
                if (this.f21291c == null) {
                    this.f21294f.f21279a.clear();
                    this.f21294f.f21280b.clear();
                }
                LinkedList<d> g2 = fVar.g();
                int size = g2.size();
                if (size <= 0) {
                    imageUrlData = null;
                    z = isEmpty;
                    this.f21294f.l = true;
                } else {
                    int i4 = 0;
                    while (i4 < size) {
                        d dVar = g2.get(i4);
                        String S = this.f21294f.S(dVar);
                        ImageUrlData imageUrlData2 = new ImageUrlData();
                        String f2 = dVar.f();
                        imageUrlData2.id = f2;
                        if (StringHelper.equals(f2, this.f21294f.A)) {
                            imageUrlData2.setSourceImageRectInScreen(this.f21294f.y);
                        }
                        imageUrlData2.imageUrl = S;
                        String str3 = S + "*" + dVar.k();
                        imageUrlData2.mWidth = dVar.r();
                        imageUrlData2.mHeigth = dVar.e();
                        imageUrlData2.urlType = 10;
                        imageUrlData2.originalUrl = dVar.i();
                        boolean z3 = isEmpty;
                        imageUrlData2.originalSize = dVar.j();
                        imageUrlData2.forumId = this.f21294f.f21286h;
                        imageUrlData2.forumName = this.f21294f.f21287i;
                        imageUrlData2.threadId = c.a.e.e.m.b.f(this.f21290b, -1L);
                        imageUrlData2.nid = this.f21294f.f21285g;
                        imageUrlData2.postId = c.a.e.e.m.b.f(dVar.c(), -1L);
                        imageUrlData2.userId = dVar.o();
                        imageUrlData2.userNameShow = StringUtils.isNull(dVar.q()) ? dVar.p() : dVar.q();
                        imageUrlData2.mIsReserver = this.f21294f.m;
                        imageUrlData2.mIsSeeHost = this.f21294f.p;
                        imageUrlData2.overAllIndex = dVar.k();
                        imageUrlData2.mThreadType = this.f21294f.v;
                        imageUrlData2.mPicType = dVar.l();
                        imageUrlData2.mTagName = dVar.n();
                        imageUrlData2.mIsShowOrigonButton = dVar.v();
                        imageUrlData2.isLongPic = dVar.u();
                        imageUrlData2.isBlockedPic = dVar.s();
                        imageUrlData2.from = this.f21294f.u;
                        if (dVar.m() != null) {
                            imageUrlData2.richTextArray = dVar.m().toString();
                        }
                        imageUrlData2.isFirstPost = dVar.t();
                        if (dVar.a() != null) {
                            AgreeData a2 = dVar.a();
                            imageUrlData2.agreeData = a2;
                            a2.isFromImageViewer = true;
                            a2.mImageViewerFromPage = this.f21294f.u;
                            imageUrlData2.agreeData.forumId = this.f21294f.f21286h;
                            imageUrlData2.agreeData.threadId = String.valueOf(imageUrlData2.threadId);
                            AgreeData agreeData2 = imageUrlData2.agreeData;
                            agreeData2.nid = imageUrlData2.nid;
                            agreeData2.postId = String.valueOf(imageUrlData2.postId);
                            imageUrlData2.agreeData.indexOfPic = imageUrlData2.overAllIndex;
                            imageUrlData2.commentNum = dVar.d();
                            if (dVar.t()) {
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
                            imageUrlData2.agreeData.cardType = this.f21294f.F;
                            imageUrlData2.agreeData.recomSource = this.f21294f.G;
                            imageUrlData2.agreeData.recomAbTag = this.f21294f.H;
                            imageUrlData2.agreeData.recomExtra = this.f21294f.J;
                            imageUrlData2.agreeData.recomWeight = this.f21294f.I;
                        }
                        if (this.f21294f.f21280b.containsKey(imageUrlData2.id)) {
                            String str4 = (String) this.f21294f.f21280b.get(imageUrlData2.id);
                            ImageUrlData imageUrlData3 = (ImageUrlData) this.f21294f.f21281c.get(str4);
                            if (imageUrlData3 == null) {
                                this.f21294f.f21281c.put(str4, imageUrlData2);
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
                                imageUrlData3.forumId = this.f21294f.f21286h;
                                imageUrlData3.forumName = this.f21294f.f21287i;
                                imageUrlData3.mHeigth = imageUrlData2.mHeigth;
                                imageUrlData3.mWidth = imageUrlData2.mWidth;
                                if (StringHelper.equals(imageUrlData2.id, this.f21294f.A)) {
                                    imageUrlData3.setSourceImageRectInScreen(this.f21294f.y);
                                }
                            }
                            str = null;
                        } else if (!this.f21294f.C) {
                            str = null;
                            this.f21294f.f21281c.put(str3, imageUrlData2);
                            if (this.f21294f.w) {
                                this.f21294f.f21279a.add(i4, str3);
                            } else {
                                this.f21294f.f21279a.add(str3);
                            }
                            this.f21294f.f21280b.put(imageUrlData2.id, str3);
                        } else {
                            c cVar3 = this.f21294f;
                            cVar3.o = cVar3.f21281c.size();
                            str = null;
                            this.f21294f.s = null;
                        }
                        i4++;
                        isEmpty = z3;
                        str2 = str;
                    }
                    String str5 = str2;
                    z = isEmpty;
                    d dVar2 = (d) ListUtils.getItem(g2, 0);
                    if (dVar2 != null) {
                        this.f21294f.f21288j = dVar2.f();
                    }
                    d dVar3 = (d) ListUtils.getItem(g2, size - 1);
                    imageUrlData = str5;
                    if (dVar3 != null) {
                        this.f21294f.k = dVar3.f();
                        c cVar4 = this.f21294f;
                        cVar4.l = ((long) cVar4.o) == dVar3.k();
                        imageUrlData = str5;
                    }
                }
                for (ImageUrlData imageUrlData4 : this.f21294f.f21281c.values()) {
                    if (imageUrlData4.agreeData == null) {
                        long j2 = imageUrlData4.postId;
                        if (imageUrlData == null) {
                            for (ImageUrlData imageUrlData5 : this.f21294f.f21281c.values()) {
                                if (imageUrlData5.postId == j2 && (agreeData = imageUrlData5.agreeData) != null) {
                                    imageUrlData4.agreeData = agreeData;
                                    imageUrlData4.richTextArray = imageUrlData5.richTextArray;
                                    imageUrlData4.commentNum = imageUrlData5.commentNum;
                                    imageUrlData4.userId = imageUrlData5.userId;
                                    imageUrlData4.userNameShow = imageUrlData5.userNameShow;
                                    imageUrlData4.forumId = this.f21294f.f21286h;
                                    imageUrlData4.forumName = this.f21294f.f21287i;
                                    imageUrlData = imageUrlData5;
                                }
                            }
                        } else if (j2 == imageUrlData.postId) {
                            imageUrlData4.agreeData = imageUrlData.agreeData;
                            imageUrlData4.richTextArray = imageUrlData.richTextArray;
                            imageUrlData4.commentNum = imageUrlData.commentNum;
                            imageUrlData4.userId = imageUrlData.userId;
                            imageUrlData4.userNameShow = imageUrlData.userNameShow;
                            imageUrlData4.forumId = this.f21294f.f21286h;
                            imageUrlData4.forumName = this.f21294f.f21287i;
                        }
                    }
                }
                if (this.f21291c == null) {
                    this.f21294f.f21284f = this.f21290b;
                    i2 = 0;
                    z2 = true;
                } else {
                    i2 = -1;
                    z2 = false;
                }
                int position = this.f21294f.w ? ListUtils.getPosition(this.f21294f.f21279a, (String) this.f21294f.f21280b.get(this.f21291c)) - 1 : i2;
                this.f21294f.D = fVar.e();
                this.f21294f.E = fVar.j();
                this.f21294f.P = fVar.f();
                if (this.f21294f.f21282d == null) {
                    this.f21294f.f21282d = new ArrayList();
                    if (fVar.d() != null && fVar.g().size() > 0) {
                        this.f21294f.f21282d.addAll(fVar.d());
                    }
                }
                if (this.f21294f.r != null) {
                    this.f21294f.r.a(this.f21294f.f21279a, position, this.f21294f.o, false, null, z2, this.f21294f.s, z);
                }
                this.f21294f.z = false;
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(ArrayList<String> arrayList, int i2, int i3, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);

        void b(int i2, String str);
    }

    public c(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2, boolean z, int i3, String str8, String str9, String str10, String str11) {
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
        this.f21280b = new HashMap<>();
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
        this.f21279a = arrayList;
        this.f21281c = map;
        if (arrayList == null) {
            this.f21279a = new ArrayList<>();
        }
        Iterator<String> it = this.f21279a.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.f21280b.put(c.a.p0.l1.a.a(next), next);
        }
        this.f21284f = str3;
        this.f21285g = str4;
        this.f21287i = str2;
        this.f21286h = str;
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

    public final String S(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) {
            if (dVar.b() != null && dVar.b().length() > 0) {
                return dVar.b();
            }
            StringBuilder sb = new StringBuilder(150);
            int threadImageMaxWidth = TbConfig.getThreadImageMaxWidth();
            int i2 = threadImageMaxWidth * threadImageMaxWidth;
            if (dVar.e() * dVar.r() > i2) {
                double sqrt = Math.sqrt(i2 / (dVar.e() * dVar.r()));
                sb.append(BigImageLoaderProc.NCDN_PER);
                sb.append(String.valueOf((int) (dVar.r() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (dVar.e() * sqrt)));
            } else {
                sb.append(BigImageLoaderProc.NCDN_PER);
                sb.append(String.valueOf(dVar.r()));
                sb.append("&height=");
                sb.append(String.valueOf(dVar.e()));
            }
            sb.append("&src=");
            sb.append(k.getUrlEncode(dVar.g()));
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public ArrayList<AlaInfoData> T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f21282d : (ArrayList) invokeV.objValue;
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
            i0(this.f21284f, this.k, 10, 0);
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.w = true;
            String str = this.f21279a.get(0);
            if (StringUtils.isNull(this.f21288j)) {
                this.f21288j = c.a.p0.l1.a.a(str);
            }
            i0(this.f21284f, this.f21288j, 0, 10);
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

    public void d0(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            this.r = bVar;
        }
    }

    public void e0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.f21283e = str;
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
