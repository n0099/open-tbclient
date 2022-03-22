package c.a.p0.w1;

import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes2.dex */
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
    public ArrayList<String> a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, String> f19643b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, ImageUrlData> f19644c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<AlaInfoData> f19645d;

    /* renamed from: e  reason: collision with root package name */
    public String f19646e;

    /* renamed from: f  reason: collision with root package name */
    public String f19647f;

    /* renamed from: g  reason: collision with root package name */
    public String f19648g;

    /* renamed from: h  reason: collision with root package name */
    public String f19649h;
    public String i;
    public String j;
    public String k;
    public boolean l;
    public boolean m;
    public a n;
    public int o;
    public boolean p;
    public boolean q;
    public InterfaceC1484b r;
    public AdvertAppInfo s;
    public String t;
    public String u;
    public int v;
    public boolean w;
    public String x;
    public String y;
    public boolean z;

    /* loaded from: classes2.dex */
    public class a extends BdAsyncTask<Object, Integer, e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;

        /* renamed from: b  reason: collision with root package name */
        public String f19650b;

        /* renamed from: c  reason: collision with root package name */
        public String f19651c;

        /* renamed from: d  reason: collision with root package name */
        public int f19652d;

        /* renamed from: e  reason: collision with root package name */
        public int f19653e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f19654f;

        public a(b bVar, String str, String str2, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, str2, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19654f = bVar;
            this.a = null;
            this.f19650b = null;
            this.f19651c = null;
            this.f19652d = 0;
            this.f19653e = 0;
            this.f19651c = str2;
            this.f19650b = str;
            this.f19652d = i;
            this.f19653e = i2;
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.addPostData("forum_id", this.f19654f.f19649h);
                this.a.addPostData("user_id", this.f19654f.t == null ? "0" : this.f19654f.t);
                this.a.addPostData(TiebaStatic.Params.SAMPLE_ID, TbSingleton.getInstance().getSampleId());
                this.a.addPostData("scr_w", String.valueOf(n.k(TbadkCoreApplication.getInst().getApp())));
                this.a.addPostData("scr_h", String.valueOf(n.i(TbadkCoreApplication.getInst().getApp())));
                this.a.addPostData("q_type", String.valueOf(TbImageHelper.getInstance().isShowBigImage() ? 2 : 1));
                this.a.addPostData(AdUploadHttpRequest.KEY_OS_VERSION, Build.VERSION.RELEASE);
                this.a.addPostData("page_name", "PB");
                this.a.addPostData("pic_index", String.valueOf(this.f19654f.a.size()));
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
                this.a = netWork;
                netWork.addPostData(TiebaStatic.Params.H5_FORUM_NAME, this.f19654f.i);
                this.a.addPostData("tid", this.f19650b);
                String str = this.f19651c;
                if (str != null) {
                    this.a.addPostData(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, str);
                }
                if (!TextUtils.isEmpty(this.f19654f.f19646e) && !"0".equals(this.f19654f.f19646e)) {
                    this.a.addPostData("post_id", this.f19654f.f19646e);
                }
                this.a.addPostData("source", String.valueOf(this.f19654f.q ? 1 : 2));
                this.f19654f.q = false;
                this.a.addPostData("next", String.valueOf(this.f19652d));
                this.a.addPostData("prev", String.valueOf(this.f19653e));
                this.a.addPostData("not_see_lz", String.valueOf(!this.f19654f.p ? 1 : 0));
                this.a.addPostData("is_top_agree", String.valueOf(this.f19654f.B ? 1 : 2));
                if (!this.f19654f.m) {
                    this.a.addPostData("r", String.valueOf(1));
                }
                if (!StringUtils.isNull(this.f19654f.u, true)) {
                    this.a.addPostData("obj_type", this.f19654f.u);
                } else {
                    this.a.addPostData("obj_type", "other");
                }
                if (TextUtils.isEmpty(this.f19654f.x)) {
                    if (System.currentTimeMillis() - c.a.o0.r.j0.b.k().m("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                        this.f19654f.x = c.a.o0.r.j0.b.k().q("applist_intalled_apk_ids", "");
                    }
                }
                this.a.addPostData("applist", this.f19654f.x);
                String lastCachedOid = PermissionUtil.getLastCachedOid(TbadkCoreApplication.getInst());
                if (!TextUtils.isEmpty(lastCachedOid)) {
                    this.a.addPostData("oaid", lastCachedOid);
                }
                this.a.addPostData("app_transmit_data", c.a.o0.c1.i.a());
                this.a.addPostData("ad_ext_params", AdExtParam.a.b().a());
                b();
                this.a.getNetContext().getRequest().mNeedBackgroundLogin = false;
                String postNetData = this.a.postNetData();
                if (this.a.getNetContext().getResponse().isRequestSuccess()) {
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
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.f19654f.n = null;
                super.cancel(true);
            }
        }

        public String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f19651c : (String) invokeV.objValue;
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
            int i;
            boolean z2;
            AgreeData agreeData;
            String str;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) {
                super.onPostExecute(eVar);
                if (this.f19654f.f19644c == null) {
                    return;
                }
                String str2 = null;
                this.f19654f.n = null;
                if (eVar == null) {
                    if (this.f19654f.r != null) {
                        NetWork netWork = this.a;
                        if (netWork != null) {
                            i2 = netWork.getServerErrorCode();
                            if (this.f19651c == null) {
                                str2 = this.a.getErrorString();
                            }
                        } else {
                            i2 = -1;
                        }
                        this.f19654f.r.b(i2, str2);
                        return;
                    }
                    return;
                }
                boolean isEmpty = ListUtils.isEmpty(eVar.g());
                if (this.f19654f.z && !isEmpty) {
                    this.f19654f.a.clear();
                    this.f19654f.f19644c.clear();
                    this.f19654f.f19643b.clear();
                }
                if (eVar.h() != 0) {
                    this.f19654f.o = eVar.h();
                }
                this.f19654f.s = eVar.a();
                this.f19654f.Q = eVar.m;
                b bVar = this.f19654f;
                bVar.K = eVar.i;
                bVar.L = eVar.i();
                b bVar2 = this.f19654f;
                bVar2.M = eVar.k;
                bVar2.N = eVar.j;
                bVar2.O = eVar.l == 1;
                if (this.f19651c == null) {
                    this.f19654f.a.clear();
                    this.f19654f.f19643b.clear();
                }
                LinkedList<c> g2 = eVar.g();
                int size = g2.size();
                if (size <= 0) {
                    imageUrlData = null;
                    z = isEmpty;
                    this.f19654f.l = true;
                } else {
                    int i3 = 0;
                    while (i3 < size) {
                        c cVar = g2.get(i3);
                        String S = this.f19654f.S(cVar);
                        ImageUrlData imageUrlData2 = new ImageUrlData();
                        String f2 = cVar.f();
                        imageUrlData2.id = f2;
                        if (StringHelper.equals(f2, this.f19654f.A)) {
                            imageUrlData2.setSourceImageRectInScreen(this.f19654f.y);
                        }
                        imageUrlData2.imageUrl = S;
                        String str3 = S + "*" + cVar.k();
                        imageUrlData2.mWidth = cVar.r();
                        imageUrlData2.mHeigth = cVar.e();
                        imageUrlData2.urlType = 10;
                        imageUrlData2.originalUrl = cVar.i();
                        boolean z3 = isEmpty;
                        imageUrlData2.originalSize = cVar.j();
                        imageUrlData2.forumId = this.f19654f.f19649h;
                        imageUrlData2.forumName = this.f19654f.i;
                        imageUrlData2.threadId = c.a.d.f.m.b.g(this.f19650b, -1L);
                        imageUrlData2.nid = this.f19654f.f19648g;
                        imageUrlData2.postId = c.a.d.f.m.b.g(cVar.c(), -1L);
                        imageUrlData2.userId = cVar.o();
                        imageUrlData2.userNameShow = StringUtils.isNull(cVar.q()) ? cVar.p() : cVar.q();
                        imageUrlData2.mIsReserver = this.f19654f.m;
                        imageUrlData2.mIsSeeHost = this.f19654f.p;
                        imageUrlData2.overAllIndex = cVar.k();
                        imageUrlData2.mThreadType = this.f19654f.v;
                        imageUrlData2.mPicType = cVar.l();
                        imageUrlData2.mTagName = cVar.n();
                        imageUrlData2.mIsShowOrigonButton = cVar.v();
                        imageUrlData2.isLongPic = cVar.u();
                        imageUrlData2.isBlockedPic = cVar.s();
                        imageUrlData2.from = this.f19654f.u;
                        if (cVar.m() != null) {
                            imageUrlData2.richTextArray = cVar.m().toString();
                        }
                        imageUrlData2.isFirstPost = cVar.t();
                        if (cVar.a() != null) {
                            AgreeData a = cVar.a();
                            imageUrlData2.agreeData = a;
                            a.isFromImageViewer = true;
                            a.mImageViewerFromPage = this.f19654f.u;
                            imageUrlData2.agreeData.forumId = this.f19654f.f19649h;
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
                            imageUrlData2.agreeData.cardType = this.f19654f.F;
                            imageUrlData2.agreeData.recomSource = this.f19654f.G;
                            imageUrlData2.agreeData.recomAbTag = this.f19654f.H;
                            imageUrlData2.agreeData.recomExtra = this.f19654f.J;
                            imageUrlData2.agreeData.recomWeight = this.f19654f.I;
                        }
                        if (this.f19654f.f19643b.containsKey(imageUrlData2.id)) {
                            String str4 = (String) this.f19654f.f19643b.get(imageUrlData2.id);
                            ImageUrlData imageUrlData3 = (ImageUrlData) this.f19654f.f19644c.get(str4);
                            if (imageUrlData3 == null) {
                                this.f19654f.f19644c.put(str4, imageUrlData2);
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
                                imageUrlData3.forumId = this.f19654f.f19649h;
                                imageUrlData3.forumName = this.f19654f.i;
                                imageUrlData3.mHeigth = imageUrlData2.mHeigth;
                                imageUrlData3.mWidth = imageUrlData2.mWidth;
                                if (StringHelper.equals(imageUrlData2.id, this.f19654f.A)) {
                                    imageUrlData3.setSourceImageRectInScreen(this.f19654f.y);
                                }
                            }
                            str = null;
                        } else if (!this.f19654f.C) {
                            str = null;
                            this.f19654f.f19644c.put(str3, imageUrlData2);
                            if (this.f19654f.w) {
                                this.f19654f.a.add(i3, str3);
                            } else {
                                this.f19654f.a.add(str3);
                            }
                            this.f19654f.f19643b.put(imageUrlData2.id, str3);
                        } else {
                            b bVar3 = this.f19654f;
                            bVar3.o = bVar3.f19644c.size();
                            str = null;
                            this.f19654f.s = null;
                        }
                        i3++;
                        isEmpty = z3;
                        str2 = str;
                    }
                    String str5 = str2;
                    z = isEmpty;
                    c cVar2 = (c) ListUtils.getItem(g2, 0);
                    if (cVar2 != null) {
                        this.f19654f.j = cVar2.f();
                    }
                    c cVar3 = (c) ListUtils.getItem(g2, size - 1);
                    imageUrlData = str5;
                    if (cVar3 != null) {
                        this.f19654f.k = cVar3.f();
                        b bVar4 = this.f19654f;
                        bVar4.l = ((long) bVar4.o) == cVar3.k();
                        imageUrlData = str5;
                    }
                }
                for (ImageUrlData imageUrlData4 : this.f19654f.f19644c.values()) {
                    if (imageUrlData4.agreeData == null) {
                        long j = imageUrlData4.postId;
                        if (imageUrlData == null) {
                            for (ImageUrlData imageUrlData5 : this.f19654f.f19644c.values()) {
                                if (imageUrlData5.postId == j && (agreeData = imageUrlData5.agreeData) != null) {
                                    imageUrlData4.agreeData = agreeData;
                                    imageUrlData4.richTextArray = imageUrlData5.richTextArray;
                                    imageUrlData4.commentNum = imageUrlData5.commentNum;
                                    imageUrlData4.userId = imageUrlData5.userId;
                                    imageUrlData4.userNameShow = imageUrlData5.userNameShow;
                                    imageUrlData4.forumId = this.f19654f.f19649h;
                                    imageUrlData4.forumName = this.f19654f.i;
                                    imageUrlData = imageUrlData5;
                                }
                            }
                        } else if (j == imageUrlData.postId) {
                            imageUrlData4.agreeData = imageUrlData.agreeData;
                            imageUrlData4.richTextArray = imageUrlData.richTextArray;
                            imageUrlData4.commentNum = imageUrlData.commentNum;
                            imageUrlData4.userId = imageUrlData.userId;
                            imageUrlData4.userNameShow = imageUrlData.userNameShow;
                            imageUrlData4.forumId = this.f19654f.f19649h;
                            imageUrlData4.forumName = this.f19654f.i;
                        }
                    }
                }
                if (this.f19651c == null) {
                    this.f19654f.f19647f = this.f19650b;
                    i = 0;
                    z2 = true;
                } else {
                    i = -1;
                    z2 = false;
                }
                int position = this.f19654f.w ? ListUtils.getPosition(this.f19654f.a, (String) this.f19654f.f19643b.get(this.f19651c)) - 1 : i;
                this.f19654f.D = eVar.e();
                this.f19654f.E = eVar.j();
                this.f19654f.P = eVar.f();
                if (this.f19654f.f19645d == null) {
                    this.f19654f.f19645d = new ArrayList();
                    if (eVar.d() != null && eVar.g().size() > 0) {
                        this.f19654f.f19645d.addAll(eVar.d());
                    }
                }
                if (this.f19654f.r != null) {
                    this.f19654f.r.a(this.f19654f.a, position, this.f19654f.o, false, null, z2, this.f19654f.s, z);
                }
                this.f19654f.z = false;
            }
        }
    }

    /* renamed from: c.a.p0.w1.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC1484b {
        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);

        void b(int i, String str);
    }

    public b(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, boolean z, int i2, String str8, String str9, String str10, String str11) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {arrayList, map, str, str2, str3, str4, str5, str6, str7, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), str8, str9, str10, str11};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19643b = new HashMap<>();
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
        this.a = arrayList;
        this.f19644c = map;
        if (arrayList == null) {
            this.a = new ArrayList<>();
        }
        Iterator<String> it = this.a.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.f19643b.put(c.a.p0.w1.a.a(next), next);
        }
        this.f19647f = str3;
        this.f19648g = str4;
        this.i = str2;
        this.f19649h = str;
        this.k = str5;
        this.v = i;
        this.l = str5 == null;
        this.t = str6;
        this.u = str7;
        this.z = z;
        this.B = false;
        this.F = i2;
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
            int i = threadImageMaxWidth * threadImageMaxWidth;
            if (cVar.e() * cVar.r() > i) {
                double sqrt = Math.sqrt(i / (cVar.e() * cVar.r()));
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
            sb.append(m.getUrlEncode(cVar.g()));
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public ArrayList<AlaInfoData> T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f19645d : (ArrayList) invokeV.objValue;
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
            i0(this.f19647f, this.k, 10, 0);
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.w = true;
            String str = this.a.get(0);
            if (StringUtils.isNull(this.j)) {
                this.j = c.a.p0.w1.a.a(str);
            }
            i0(this.f19647f, this.j, 0, 10);
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

    public void d0(InterfaceC1484b interfaceC1484b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, interfaceC1484b) == null) {
            this.r = interfaceC1484b;
        }
    }

    public void e0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.f19646e = str;
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

    public final void i0(String str, String str2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048592, this, str, str2, i, i2) == null) {
            a aVar = this.n;
            if (aVar != null) {
                if (str2 != null && str2.equals(aVar.d())) {
                    return;
                }
                this.n.cancel();
            }
            a aVar2 = new a(this, str, str2, i, i2);
            this.n = aVar2;
            aVar2.setPriority(3);
            this.n.execute(new Object[0]);
        }
    }
}
