package c.a.r0.q2.u.f.c1;

import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.f;
import c.a.d.f.p.l;
import c.a.d.f.p.q;
import c.a.q0.t.c.w;
import c.a.r0.q2.g;
import c.a.r0.q2.h;
import c.a.r0.q2.u.f.c1.b;
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
/* loaded from: classes6.dex */
public class c implements QueryMatchEmotionModel.b, b.InterfaceC1276b, EmotionView.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public f f21844e;

    /* renamed from: f  reason: collision with root package name */
    public List<String> f21845f;

    /* renamed from: g  reason: collision with root package name */
    public HListView f21846g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.q2.u.f.c1.b f21847h;

    /* renamed from: i  reason: collision with root package name */
    public QueryMatchEmotionModel f21848i;

    /* renamed from: j  reason: collision with root package name */
    public String f21849j;

    /* renamed from: k  reason: collision with root package name */
    public Handler f21850k;
    public ViewGroup l;
    public ViewGroup.LayoutParams m;
    public EditorTools n;
    public GetEmotionPidModel o;
    public Runnable p;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f21851e;

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
            this.f21851e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21851e.f21849j = "";
                this.f21851e.f21846g.setVisibility(8);
            }
        }
    }

    /* loaded from: classes6.dex */
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
                    this.a.f21850k.removeCallbacks(this.a.p);
                    this.a.f21850k.postDelayed(this.a.p, 5000L);
                } else if (i2 != 1) {
                } else {
                    this.a.f21850k.removeCallbacks(this.a.p);
                }
            }
        }
    }

    /* renamed from: c.a.r0.q2.u.f.c1.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1277c implements GetEmotionPidModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionImageData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f21852b;

        public C1277c(c cVar, EmotionImageData emotionImageData) {
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
            this.f21852b = cVar;
            this.a = emotionImageData;
        }

        @Override // com.baidu.tbadk.img.GetEmotionPidModel.b
        public void a(c.a.q0.d0.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null || TextUtils.isEmpty(cVar.a)) {
                return;
            }
            this.a.setPicId(cVar.a);
            this.f21852b.j(this.a);
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
        this.f21844e = fVar;
        this.l = viewGroup;
        this.m = layoutParams;
        this.f21850k = new Handler();
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.b
    public void a(String str, List<EmotionImageData> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) && !TextUtils.isEmpty(str) && str.equals(this.f21849j)) {
            if (ListUtils.isEmpty(list)) {
                this.f21849j = "";
            } else if (this.l == null || this.m == null) {
            } else {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                HListView hListView = this.f21846g;
                if (hListView == null || hListView.getParent() == null) {
                    HListView hListView2 = new HListView(this.f21844e.getContext());
                    this.f21846g = hListView2;
                    SkinManager.setBackgroundColor(hListView2, c.a.r0.q2.f.CAM_X0201);
                    this.f21846g.setDividerWidth(l.f(this.f21844e.getPageActivity(), g.ds7));
                    this.f21846g.setClipToPadding(false);
                    int f2 = l.f(this.f21844e.getPageActivity(), g.ds10);
                    this.f21846g.setPadding(f2, f2, f2, f2);
                    this.f21846g.setSelector(h.list_selector_transparent);
                    this.m.height = l.f(this.f21844e.getPageActivity(), g.ds136);
                    this.l.addView(this.f21846g, this.m);
                    if (this.f21847h == null) {
                        c.a.r0.q2.u.f.c1.b bVar = new c.a.r0.q2.u.f.c1.b();
                        this.f21847h = bVar;
                        bVar.d(this);
                        this.f21847h.c(this);
                        this.f21846g.setAdapter((ListAdapter) this.f21847h);
                        this.f21846g.setOnScrollListener(new b(this));
                    }
                }
                this.f21846g.setVisibility(0);
                this.f21847h.b(list);
                this.f21847h.notifyDataSetChanged();
                this.f21846g.setSelection(0);
                this.f21850k.removeCallbacks(this.p);
                this.f21850k.postDelayed(this.p, 5000L);
            }
        }
    }

    @Override // c.a.r0.q2.u.f.c1.b.InterfaceC1276b
    public void b(EmotionImageData emotionImageData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, emotionImageData) == null) {
            this.f21850k.removeCallbacks(this.p);
            this.f21850k.postDelayed(this.p, 5000L);
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
            this.o.x(emotionImageData.getPicUrl(), new C1277c(this, emotionImageData));
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
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (queryMatchEmotionModel = this.f21848i) == null) {
            return;
        }
        queryMatchEmotionModel.cancelLoadData();
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            HListView hListView = this.f21846g;
            if (hListView != null) {
                hListView.setVisibility(8);
            }
            this.f21850k.removeCallbacks(this.p);
            this.f21849j = "";
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
            String lowerCase = q.c(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX_SHORT + sb.toString() + "7S6wbXjEKL9N").toLowerCase();
            wVar.j("#(meme,net_" + Uri.encode(emotionImageData.getPicUrl()) + "," + sb.toString() + lowerCase + SmallTailInfo.EMOTION_SUFFIX);
            wVar.m(EmotionGroupType.NET_SUG);
            wVar.o(emotionImageData.getWidth());
            wVar.i(emotionImageData.getHeight());
            wVar.n(emotionImageData.getPicUrl());
            this.n.sendAction(new c.a.q0.x.a(24, -1, wVar));
        }
    }

    public final void k(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || TextUtils.isEmpty(str) || str.equals(this.f21849j)) {
            return;
        }
        this.f21849j = str;
        if (this.f21848i == null) {
            this.f21848i = new QueryMatchEmotionModel(this.f21844e);
        }
        this.f21848i.z(str, this);
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || TextUtils.isEmpty(str) || ListUtils.isEmpty(this.f21845f) || !this.f21845f.contains(str)) {
            return;
        }
        k(str);
    }

    public void m(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.f21845f = list;
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
            this.f21850k.removeCallbacks(this.p);
        }
    }

    @Override // com.baidu.tieba.face.view.EmotionView.c
    public void startStopPreview() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f21850k.removeCallbacks(this.p);
            this.f21850k.postDelayed(this.p, 5000L);
        }
    }
}
