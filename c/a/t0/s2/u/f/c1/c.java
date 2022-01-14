package c.a.t0.s2.u.f.c1;

import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.f;
import c.a.d.f.p.n;
import c.a.d.f.p.t;
import c.a.s0.t.c.w;
import c.a.t0.s2.g;
import c.a.t0.s2.h;
import c.a.t0.s2.u.f.c1.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.EmotionUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.img.GetEmotionPidModel;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class c implements QueryMatchEmotionModel.b, b.InterfaceC1400b, EmotionView.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public f f22717e;

    /* renamed from: f  reason: collision with root package name */
    public List<String> f22718f;

    /* renamed from: g  reason: collision with root package name */
    public HListView f22719g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.t0.s2.u.f.c1.b f22720h;

    /* renamed from: i  reason: collision with root package name */
    public QueryMatchEmotionModel f22721i;

    /* renamed from: j  reason: collision with root package name */
    public String f22722j;
    public Handler k;
    public ViewGroup l;
    public ViewGroup.LayoutParams m;
    public EditorTools n;
    public GetEmotionPidModel o;
    public Runnable p;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f22723e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22723e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22723e.f22722j = "";
                this.f22723e.f22719g.setVisibility(8);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements AbsHListView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.i
        public void a(AbsHListView absHListView, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absHListView, i2, i3, i4) == null) {
            }
        }

        @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.i
        public void b(AbsHListView absHListView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absHListView, i2) == null) {
                if (i2 == 0) {
                    this.a.k.removeCallbacks(this.a.p);
                    this.a.k.postDelayed(this.a.p, 5000L);
                } else if (i2 != 1) {
                } else {
                    this.a.k.removeCallbacks(this.a.p);
                }
            }
        }
    }

    /* renamed from: c.a.t0.s2.u.f.c1.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1401c implements GetEmotionPidModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionImageData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f22724b;

        public C1401c(c cVar, EmotionImageData emotionImageData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, emotionImageData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22724b = cVar;
            this.a = emotionImageData;
        }

        @Override // com.baidu.tbadk.img.GetEmotionPidModel.b
        public void a(c.a.s0.d0.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null || TextUtils.isEmpty(cVar.a)) {
                return;
            }
            this.a.setPicId(cVar.a);
            this.f22724b.j(this.a);
        }

        @Override // com.baidu.tbadk.img.GetEmotionPidModel.b
        public void onFail(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
            }
        }
    }

    public c(f fVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, viewGroup, layoutParams};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = new a(this);
        this.f22717e = fVar;
        this.l = viewGroup;
        this.m = layoutParams;
        this.k = new Handler();
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.b
    public void a(String str, List<EmotionImageData> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) && !TextUtils.isEmpty(str) && str.equals(this.f22722j)) {
            if (ListUtils.isEmpty(list)) {
                this.f22722j = "";
            } else if (this.l == null || this.m == null) {
            } else {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                HListView hListView = this.f22719g;
                if (hListView == null || hListView.getParent() == null) {
                    HListView hListView2 = new HListView(this.f22717e.getContext());
                    this.f22719g = hListView2;
                    SkinManager.setBackgroundColor(hListView2, c.a.t0.s2.f.CAM_X0201);
                    this.f22719g.setDividerWidth(n.f(this.f22717e.getPageActivity(), g.ds7));
                    this.f22719g.setClipToPadding(false);
                    int f2 = n.f(this.f22717e.getPageActivity(), g.ds10);
                    this.f22719g.setPadding(f2, f2, f2, f2);
                    this.f22719g.setSelector(h.list_selector_transparent);
                    this.m.height = n.f(this.f22717e.getPageActivity(), g.ds136);
                    this.l.addView(this.f22719g, this.m);
                    if (this.f22720h == null) {
                        c.a.t0.s2.u.f.c1.b bVar = new c.a.t0.s2.u.f.c1.b();
                        this.f22720h = bVar;
                        bVar.d(this);
                        this.f22720h.c(this);
                        this.f22719g.setAdapter((ListAdapter) this.f22720h);
                        this.f22719g.setOnScrollListener(new b(this));
                    }
                }
                this.f22719g.setVisibility(0);
                this.f22720h.b(list);
                this.f22720h.notifyDataSetChanged();
                this.f22719g.setSelection(0);
                this.k.removeCallbacks(this.p);
                this.k.postDelayed(this.p, 5000L);
            }
        }
    }

    @Override // c.a.t0.s2.u.f.c1.b.InterfaceC1400b
    public void b(EmotionImageData emotionImageData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, emotionImageData) == null) {
            this.k.removeCallbacks(this.p);
            this.k.postDelayed(this.p, 5000L);
            if (emotionImageData == null || TextUtils.isEmpty(emotionImageData.getPicUrl()) || this.n == null) {
                return;
            }
            if (!TextUtils.isEmpty(emotionImageData.getPicId()) && !emotionImageData.getPicId().equals("0")) {
                j(emotionImageData);
                return;
            }
            if (this.o == null) {
                this.o = new GetEmotionPidModel();
            }
            this.o.x(emotionImageData.getPicUrl(), new C1401c(this, emotionImageData));
        }
    }

    @Override // com.baidu.tieba.face.view.EmotionView.c
    public boolean canClick() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.c
    public boolean canShowPreview() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void h() {
        QueryMatchEmotionModel queryMatchEmotionModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (queryMatchEmotionModel = this.f22721i) == null) {
            return;
        }
        queryMatchEmotionModel.cancelLoadData();
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            HListView hListView = this.f22719g;
            if (hListView != null) {
                hListView.setVisibility(8);
            }
            this.k.removeCallbacks(this.p);
            this.f22722j = "";
        }
    }

    public final void j(EmotionImageData emotionImageData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, emotionImageData) == null) {
            TiebaStatic.log("c12489");
            w wVar = new w();
            StringBuilder sb = new StringBuilder();
            sb.append(emotionImageData.getPicId());
            sb.append(",");
            sb.append(emotionImageData.getWidth());
            sb.append(",");
            sb.append(emotionImageData.getHeight());
            sb.append(",");
            String lowerCase = t.c(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX_SHORT + sb.toString() + "7S6wbXjEKL9N").toLowerCase();
            wVar.j("#(meme,net_" + Uri.encode(emotionImageData.getPicUrl()) + "," + sb.toString() + lowerCase + SmallTailInfo.EMOTION_SUFFIX);
            wVar.m(EmotionGroupType.NET_SUG);
            wVar.o(emotionImageData.getWidth());
            wVar.i(emotionImageData.getHeight());
            wVar.n(emotionImageData.getPicUrl());
            this.n.sendAction(new c.a.s0.x.a(24, -1, wVar));
        }
    }

    public final void k(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || TextUtils.isEmpty(str) || str.equals(this.f22722j)) {
            return;
        }
        this.f22722j = str;
        if (this.f22721i == null) {
            this.f22721i = new QueryMatchEmotionModel(this.f22717e);
        }
        this.f22721i.z(str, this);
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || TextUtils.isEmpty(str) || ListUtils.isEmpty(this.f22718f) || !this.f22718f.contains(str)) {
            return;
        }
        k(str);
    }

    public void m(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.f22718f = list;
        }
    }

    public void n(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, editorTools) == null) {
            this.n = editorTools;
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.b
    public void onFail(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048587, this, i2, str) == null) {
        }
    }

    @Override // com.baidu.tieba.face.view.EmotionView.c
    public void startShowPreview() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.k.removeCallbacks(this.p);
        }
    }

    @Override // com.baidu.tieba.face.view.EmotionView.c
    public void startStopPreview() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.k.removeCallbacks(this.p);
            this.k.postDelayed(this.p, 5000L);
        }
    }
}
