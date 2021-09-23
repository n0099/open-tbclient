package c.a.r0.j2.o.g;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.ViewModelProviders;
import c.a.e.e.p.l;
import c.a.e.l.e.n;
import c.a.r0.j2.h.e;
import c.a.r0.j2.h.f;
import c.a.r0.j2.i.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseVideoPBReplyFragment f20697a;

    /* renamed from: b  reason: collision with root package name */
    public AbsVideoPbFragment f20698b;

    /* renamed from: c  reason: collision with root package name */
    public int f20699c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f20700d;

    /* renamed from: e  reason: collision with root package name */
    public final TbRichTextView.z f20701e;

    /* renamed from: f  reason: collision with root package name */
    public c f20702f;

    /* loaded from: classes3.dex */
    public class a implements TbRichTextView.z {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f20703a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20703a = bVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r9v14, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$b */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.z
        public void a(View view, String str, int i2, boolean z, boolean z2) {
            c.a.r0.j2.o.h.a adapterManager;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, str, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    StatisticItem statisticItem = new StatisticItem("c13398");
                    statisticItem.param("tid", this.f20703a.f20697a.getPbModel().f1());
                    statisticItem.param("fid", this.f20703a.f20697a.getPbModel().getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("obj_locate", 3);
                    statisticItem.param("obj_type", z2 ? 1 : 2);
                    TiebaStatic.log(statisticItem);
                    if (this.f20703a.f20698b.isCommentFloatPage()) {
                        StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                        statisticItem2.param("fid", this.f20703a.f20697a.getPbModel().getForumId());
                        statisticItem2.param("tid", this.f20703a.f20697a.getPbModel().f1());
                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem2.param("post_id", this.f20703a.f20697a.getPbModel().p0());
                        statisticItem2.param("obj_source", 1);
                        statisticItem2.param("obj_type", 10);
                        statisticItem2.param("obj_locate", this.f20703a.f20698b.getFromVideoPageType());
                        TiebaStatic.log(statisticItem2);
                    }
                    TiebaStatic.eventStat(this.f20703a.f20697a.getPageContext().getPageActivity(), "pic_pb", "");
                    if (this.f20703a.f20697a.getPbModel().P0().f0()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        int i3 = -1;
                        if (view.getParent() instanceof TbRichTextView) {
                            TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                            if (tbRichTextView.getRichText() != null && tbRichTextView.getRichText().A() != null) {
                                ArrayList<TbRichTextImageInfo> A = tbRichTextView.getRichText().A();
                                int i4 = -1;
                                for (int i5 = 0; i5 < A.size(); i5++) {
                                    if (A.get(i5) != null) {
                                        arrayList.add(A.get(i5).B());
                                        if (i4 == -1 && str != null && str.equals(A.get(i5).B())) {
                                            i4 = i5;
                                        }
                                        ImageUrlData imageUrlData = new ImageUrlData();
                                        imageUrlData.imageUrl = A.get(i5).B();
                                        imageUrlData.originalUrl = A.get(i5).B();
                                        imageUrlData.isLongPic = A.get(i5).E();
                                        concurrentHashMap.put(A.get(i5).B(), imageUrlData);
                                    }
                                }
                                i3 = i4;
                            }
                        }
                        ImageViewerConfig.b bVar = new ImageViewerConfig.b();
                        bVar.x(arrayList);
                        bVar.B(i3);
                        bVar.C(false);
                        bVar.F(this.f20703a.f20697a.getPbModel().a1());
                        bVar.w(concurrentHashMap);
                        bVar.H(true);
                        bVar.K(false);
                        if (this.f20703a.f20697a.getPbModel() != null) {
                            bVar.G(this.f20703a.f20697a.getPbModel().t0());
                            bVar.A(this.f20703a.f20697a.getPbModel().getFromForumId());
                            if (this.f20703a.f20697a.getPbModel().P0() != null) {
                                bVar.N(this.f20703a.f20697a.getPbModel().P0().O());
                            }
                        }
                        ImageViewerConfig v = bVar.v(this.f20703a.f20697a.getPageContext().getPageActivity());
                        v.getIntent().putExtra("from", "pb");
                        this.f20703a.f20697a.sendMessage(new CustomMessage(2010000, v));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                        return;
                    }
                    AbsPbActivity.e eVar = new AbsPbActivity.e();
                    this.f20703a.m(str, i2, eVar);
                    if (eVar.f55060h) {
                        TbRichText p = this.f20703a.p(str, i2);
                        if (p != null && this.f20703a.f20699c >= 0 && this.f20703a.f20699c < p.y().size()) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            String a2 = f.a(p.y().get(this.f20703a.f20699c));
                            int i6 = 0;
                            while (true) {
                                if (i6 >= eVar.f55053a.size()) {
                                    break;
                                } else if (eVar.f55053a.get(i6).equals(a2)) {
                                    eVar.f55062j = i6;
                                    arrayList2.add(a2);
                                    break;
                                } else {
                                    i6++;
                                }
                            }
                            if (p.getPostId() != 0 && (adapterManager = this.f20703a.f20697a.getAdapterManager()) != null) {
                                ArrayList<n> a3 = adapterManager.a();
                                if (ListUtils.getCount(a3) > 0) {
                                    Iterator<n> it = a3.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        n next = it.next();
                                        if ((next instanceof PostData) && p.getPostId() == c.a.e.e.m.b.g(((PostData) next).E(), 0L)) {
                                            c.a.r0.j2.m.a.b(this.f20703a.f20697a.getPbModel().P0(), (PostData) next, ((PostData) next).i0, 8, 3);
                                            break;
                                        }
                                    }
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                            if (!ListUtils.isEmpty(arrayList2)) {
                                String str2 = arrayList2.get(0);
                                concurrentHashMap2.put(str2, eVar.f55054b.get(str2));
                            }
                            ImageViewerConfig.b bVar2 = new ImageViewerConfig.b();
                            bVar2.x(arrayList2);
                            bVar2.z(eVar.f55055c);
                            bVar2.y(eVar.f55056d);
                            bVar2.O(eVar.f55057e);
                            bVar2.C(eVar.f55059g);
                            bVar2.H(true);
                            bVar2.J(eVar.f55061i);
                            bVar2.w(concurrentHashMap2);
                            bVar2.K(false);
                            bVar2.F(this.f20703a.f20697a.getPbModel().a1());
                            bVar2.L(eVar.f55058f);
                            if (this.f20703a.f20697a.getPbModel() != null) {
                                bVar2.G(this.f20703a.f20697a.getPbModel().t0());
                                bVar2.A(this.f20703a.f20697a.getPbModel().getFromForumId());
                                if (this.f20703a.f20697a.getPbModel().P0() != null) {
                                    bVar2.N(this.f20703a.f20697a.getPbModel().P0().O());
                                }
                            }
                            ImageViewerConfig v2 = bVar2.v(this.f20703a.f20697a.getPageContext().getPageActivity());
                            v2.getIntent().putExtra("from", "pb");
                            this.f20703a.f20697a.sendMessage(new CustomMessage(2010000, v2));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                            return;
                        }
                        return;
                    }
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(ListUtils.getItem(eVar.f55053a, 0));
                    ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
                    if (!ListUtils.isEmpty(arrayList3)) {
                        String str3 = (String) arrayList3.get(0);
                        concurrentHashMap3.put(str3, eVar.f55054b.get(str3));
                    }
                    ImageViewerConfig.b bVar3 = new ImageViewerConfig.b();
                    bVar3.x(arrayList3);
                    bVar3.z(eVar.f55055c);
                    bVar3.y(eVar.f55056d);
                    bVar3.O(eVar.f55057e);
                    bVar3.C(eVar.f55059g);
                    bVar3.H(true);
                    bVar3.J(eVar.f55053a.get(0));
                    bVar3.w(concurrentHashMap3);
                    bVar3.F(this.f20703a.f20697a.getPbModel().a1());
                    bVar3.K(false);
                    bVar3.L(eVar.f55058f);
                    bVar3.D(false);
                    if (this.f20703a.f20697a.getPbModel() != null) {
                        bVar3.G(this.f20703a.f20697a.getPbModel().t0());
                        bVar3.A(this.f20703a.f20697a.getPbModel().getFromForumId());
                        if (this.f20703a.f20697a.getPbModel().P0() != null) {
                            bVar3.N(this.f20703a.f20697a.getPbModel().P0().O());
                        }
                    }
                    ImageViewerConfig v3 = bVar3.v(this.f20703a.f20697a.getPageContext().getPageActivity());
                    v3.getIntent().putExtra("from", "pb");
                    this.f20703a.f20697a.sendMessage(new CustomMessage(2010000, v3));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
        }
    }

    /* renamed from: c.a.r0.j2.o.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0977b implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f20704a;

        public C0977b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20704a = bVar;
        }

        @Override // c.a.r0.j2.i.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // c.a.r0.j2.i.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent)) == null) {
                AbsVideoPbFragment absVideoPbFragment = this.f20704a.f20698b;
                if (absVideoPbFragment != null && absVideoPbFragment.isAdded()) {
                    if (view != null) {
                        if (view.getId() == R.id.richText) {
                            AbsVideoPbFragment absVideoPbFragment2 = this.f20704a.f20698b;
                            if (absVideoPbFragment2 != null && absVideoPbFragment2.richTextHandleSingleTap(view)) {
                                return true;
                            }
                        } else if (view.getId() == R.id.pb_floor_item_layout) {
                            if (view.getTag(R.id.tag_from) instanceof SparseArray) {
                                this.f20704a.o((SparseArray) view.getTag(R.id.tag_from));
                            }
                        } else if ((view instanceof TbRichTextView) || view.getId() == R.id.pb_post_header_layout) {
                            SparseArray sparseArray = view.getTag() instanceof SparseArray ? (SparseArray) view.getTag() : null;
                            if (sparseArray == null) {
                                return false;
                            }
                            this.f20704a.o(sparseArray);
                        }
                    }
                    AbsVideoPbFragment absVideoPbFragment3 = this.f20704a.f20698b;
                    if (absVideoPbFragment3 != null) {
                        absVideoPbFragment3.tapResetEditor();
                    }
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // c.a.r0.j2.i.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, motionEvent)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    public b(BaseVideoPBReplyFragment baseVideoPBReplyFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseVideoPBReplyFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20699c = 0;
        this.f20700d = false;
        this.f20701e = new a(this);
        this.f20702f = new c(new C0977b(this));
        this.f20697a = baseVideoPBReplyFragment;
        this.f20698b = baseVideoPBReplyFragment.getVideoPbFragment();
    }

    public final void d(e eVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, eVar, arrayList) == null) || eVar == null || eVar.T() == null || eVar.T().f19694a == null || (list = eVar.T().f19694a) == null || arrayList == null) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (list.size() <= 0 || arrayList.size() <= 0) {
            return;
        }
        arrayList3.addAll(list);
        Iterator<PostData> it = arrayList.iterator();
        while (it.hasNext()) {
            PostData next = it.next();
            if (next != null) {
                Iterator it2 = arrayList3.iterator();
                while (it2.hasNext()) {
                    PostData postData = (PostData) it2.next();
                    if (postData != null && !TextUtils.isEmpty(next.E()) && !TextUtils.isEmpty(postData.E()) && next.E().equals(postData.E())) {
                        arrayList2.add(postData);
                    }
                }
            }
        }
        if (arrayList2.size() > 0) {
            arrayList3.removeAll(arrayList2);
        }
        if (arrayList3.size() > 0) {
            arrayList.addAll(arrayList3);
        }
    }

    public final TbRichText e(ArrayList<PostData> arrayList, String str, int i2) {
        InterceptResult invokeLLI;
        ArrayList<TbRichTextData> y;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, str, i2)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    TbRichText K = arrayList.get(i3).K();
                    if (K != null && (y = K.y()) != null) {
                        int size = y.size();
                        int i4 = -1;
                        for (int i5 = 0; i5 < size; i5++) {
                            if (y.get(i5) != null && y.get(i5).getType() == 8) {
                                i4++;
                                if (y.get(i5).C().y().equals(str) || y.get(i5).C().z().equals(str)) {
                                    int h2 = (int) l.h(TbadkCoreApplication.getInst());
                                    int width = y.get(i5).C().getWidth() * h2;
                                    int height = y.get(i5).C().getHeight() * h2;
                                    if (width < 80 || height < 80 || width * height < 10000) {
                                        return null;
                                    }
                                    this.f20699c = i5;
                                    return K;
                                } else if (i4 > i2) {
                                    break;
                                }
                            }
                        }
                        continue;
                    }
                }
            }
            return null;
        }
        return (TbRichText) invokeLLI.objValue;
    }

    public final int f(TbRichText tbRichText, TbRichText tbRichText2, int i2, int i3, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        InterceptResult invokeCommon;
        TbRichTextImageInfo C;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i2), Integer.valueOf(i3), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                this.f20700d = true;
            }
            if (tbRichText != null) {
                int size = tbRichText.y().size();
                int i4 = i2;
                int i5 = -1;
                for (int i6 = 0; i6 < size; i6++) {
                    TbRichTextData tbRichTextData = tbRichText.y().get(i6);
                    if ((tbRichTextData == null || tbRichTextData.getType() != 20) && tbRichTextData != null && tbRichTextData.getType() == 8) {
                        i5++;
                        int h2 = (int) l.h(TbadkCoreApplication.getInst());
                        int width = tbRichTextData.C().getWidth() * h2;
                        int height = tbRichTextData.C().getHeight() * h2;
                        if ((width < 80 || height < 80 || width * height < 10000) || !tbRichTextData.C().D()) {
                            if (tbRichText == tbRichText2) {
                                if (i5 <= i3) {
                                    i4--;
                                }
                            }
                        } else if (tbRichTextData.getType() != 20) {
                            String a2 = f.a(tbRichTextData);
                            if (!TextUtils.isEmpty(a2)) {
                                arrayList.add(a2);
                                if (tbRichTextData != null && (C = tbRichTextData.C()) != null) {
                                    String y = C.y();
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                        imageUrlData.urlType = 38;
                                        y = C.z();
                                    } else {
                                        imageUrlData.urlType = ((VideoPbViewModel) ViewModelProviders.of(this.f20697a.getPbActivity()).get(VideoPbViewModel.class)).isFromCDN() ? 17 : 18;
                                    }
                                    imageUrlData.imageUrl = y;
                                    imageUrlData.originalUrl = j(tbRichTextData);
                                    imageUrlData.originalSize = k(tbRichTextData);
                                    imageUrlData.mIsShowOrigonButton = h(tbRichTextData);
                                    imageUrlData.isLongPic = g(tbRichTextData);
                                    imageUrlData.postId = tbRichText.getPostId();
                                    imageUrlData.threadId = c.a.e.e.m.b.g(this.f20697a.getPbModel().f1(), -1L);
                                    imageUrlData.mIsReserver = this.f20697a.getPbModel().a1();
                                    imageUrlData.mIsSeeHost = this.f20697a.getPbModel().t0();
                                    if (concurrentHashMap != null) {
                                        concurrentHashMap.put(a2, imageUrlData);
                                    }
                                }
                            }
                            if (!this.f20700d) {
                                i4++;
                            }
                        }
                    }
                }
                return i4;
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    public final boolean g(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.C() == null) {
                return false;
            }
            return tbRichTextData.C().E();
        }
        return invokeL.booleanValue;
    }

    public final boolean h(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.C() == null) {
                return false;
            }
            return tbRichTextData.C().F();
        }
        return invokeL.booleanValue;
    }

    public TbRichTextView.z i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f20701e : (TbRichTextView.z) invokeV.objValue;
    }

    public final String j(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.C() == null) {
                return null;
            }
            return tbRichTextData.C().A();
        }
        return (String) invokeL.objValue;
    }

    public final long k(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.C() == null) {
                return 0L;
            }
            return tbRichTextData.C().getOriginalSize();
        }
        return invokeL.longValue;
    }

    public c l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f20702f : (c) invokeV.objValue;
    }

    public void m(String str, int i2, AbsPbActivity.e eVar) {
        TbRichTextData tbRichTextData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048585, this, str, i2, eVar) == null) || eVar == null) {
            return;
        }
        e P0 = this.f20697a.getPbModel().P0();
        TbRichText p = p(str, i2);
        if (p == null || (tbRichTextData = p.y().get(this.f20699c)) == null) {
            return;
        }
        eVar.f55058f = String.valueOf(p.getPostId());
        eVar.f55053a = new ArrayList<>();
        eVar.f55054b = new ConcurrentHashMap<>();
        if (!tbRichTextData.C().D()) {
            eVar.f55060h = false;
            String a2 = f.a(tbRichTextData);
            eVar.f55053a.add(a2);
            ImageUrlData imageUrlData = new ImageUrlData();
            imageUrlData.imageUrl = str;
            if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                imageUrlData.urlType = 38;
            } else {
                imageUrlData.urlType = ((VideoPbViewModel) ViewModelProviders.of(this.f20697a.getPbActivity()).get(VideoPbViewModel.class)).isFromCDN() ? 17 : 18;
            }
            imageUrlData.originalUrl = j(tbRichTextData);
            imageUrlData.originalUrl = j(tbRichTextData);
            imageUrlData.originalSize = k(tbRichTextData);
            imageUrlData.mIsShowOrigonButton = h(tbRichTextData);
            imageUrlData.isLongPic = g(tbRichTextData);
            imageUrlData.postId = p.getPostId();
            imageUrlData.mIsReserver = this.f20697a.getPbModel().a1();
            imageUrlData.mIsSeeHost = this.f20697a.getPbModel().t0();
            eVar.f55054b.put(a2, imageUrlData);
            if (P0 != null) {
                if (P0.m() != null) {
                    eVar.f55055c = P0.m().getName();
                    eVar.f55056d = P0.m().getId();
                }
                if (P0.O() != null) {
                    eVar.f55057e = P0.O().f0();
                }
                eVar.f55059g = P0.t() == 1;
            }
            imageUrlData.threadId = c.a.e.e.m.b.g(eVar.f55057e, -1L);
            return;
        }
        eVar.f55060h = true;
        int size = P0.F().size();
        this.f20700d = false;
        eVar.f55062j = -1;
        int f2 = P0.j() != null ? f(P0.j().K(), p, i2, i2, eVar.f55053a, eVar.f55054b) : i2;
        for (int i3 = 0; i3 < size; i3++) {
            PostData postData = P0.F().get(i3);
            if (postData.E() == null || P0.j() == null || P0.j().E() == null || !postData.E().equals(P0.j().E())) {
                f2 = f(postData.K(), p, f2, i2, eVar.f55053a, eVar.f55054b);
            }
        }
        if (eVar.f55053a.size() > 0) {
            ArrayList<String> arrayList = eVar.f55053a;
            eVar.f55061i = arrayList.get(arrayList.size() - 1);
        }
        if (P0 != null) {
            if (P0.m() != null) {
                eVar.f55055c = P0.m().getName();
                eVar.f55056d = P0.m().getId();
            }
            if (P0.O() != null) {
                eVar.f55057e = P0.O().f0();
            }
            eVar.f55059g = P0.t() == 1;
        }
        eVar.f55062j = f2;
    }

    public AbsPbActivity.e n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            String str2 = null;
            if (this.f20697a.getPbModel() != null && this.f20697a.getPbModel().P0() != null && this.f20697a.getPbModel().P0().F() != null && this.f20697a.getPbModel().P0().F().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i2 = 0;
                while (true) {
                    if (i2 >= this.f20697a.getPbModel().P0().F().size()) {
                        i2 = 0;
                        break;
                    } else if (str.equals(this.f20697a.getPbModel().P0().F().get(i2).E())) {
                        break;
                    } else {
                        i2++;
                    }
                }
                PostData postData = this.f20697a.getPbModel().P0().F().get(i2);
                if (postData.K() != null && postData.K().y() != null) {
                    Iterator<TbRichTextData> it = postData.K().y().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        TbRichTextData next = it.next();
                        if (next != null && next.getType() == 8) {
                            if (next.C() != null) {
                                str2 = next.C().y();
                            }
                        }
                    }
                    m(str2, 0, eVar);
                    f.b(postData, eVar);
                    return eVar;
                }
            }
            return null;
        }
        return (AbsPbActivity.e) invokeL.objValue;
    }

    public final void o(SparseArray<Object> sparseArray) {
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, sparseArray) == null) || !this.f20697a.checkUpIsLogin() || sparseArray == null || !(sparseArray.get(R.id.tag_clip_board) instanceof PostData) || (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) == null || this.f20697a.getPbModel() == null || this.f20697a.getPbModel().P0() == null || postData.A() == 1) {
            return;
        }
        String f1 = this.f20697a.getPbModel().f1();
        String E = postData.E();
        int V = this.f20697a.getPbModel().P0() != null ? this.f20697a.getPbModel().P0().V() : 0;
        AbsPbActivity.e n = n(E);
        if (n == null) {
            return;
        }
        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.f20697a.getPageContext().getPageActivity()).createSubPbActivityConfig(f1, E, "pb", true, this.f20698b.isCommentFloatPage(), null, false, null, V, postData.P(), this.f20697a.getPbModel().P0().d(), false, postData.t() != null ? postData.t().getIconInfo() : null, 0).addBigImageData(n.f55053a, n.f55054b, n.f55059g, n.f55062j);
        addBigImageData.setKeyPageStartFrom(this.f20697a.getPbModel().O0());
        addBigImageData.setFromFrsForumId(this.f20697a.getPbModel().getFromForumId());
        addBigImageData.setWorksInfoData(this.f20697a.getPbModel().j1());
        addBigImageData.setKeyFromForumId(this.f20697a.getPbModel().getForumId());
        addBigImageData.setBjhData(this.f20697a.getPbModel().j0());
        this.f20697a.sendMessage(new CustomMessage(2002001, addBigImageData));
    }

    public final TbRichText p(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048588, this, str, i2)) == null) {
            TbRichText tbRichText = null;
            if (this.f20697a.getPbModel() == null || this.f20697a.getPbModel().P0() == null || str == null || i2 < 0) {
                return null;
            }
            e P0 = this.f20697a.getPbModel().P0();
            if (P0.j() != null) {
                ArrayList<PostData> arrayList = new ArrayList<>();
                arrayList.add(P0.j());
                tbRichText = e(arrayList, str, i2);
            }
            if (tbRichText == null) {
                ArrayList<PostData> F = P0.F();
                d(P0, F);
                return e(F, str, i2);
            }
            return tbRichText;
        }
        return (TbRichText) invokeLI.objValue;
    }
}
