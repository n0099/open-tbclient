package c.a.q0.i2.k.e.z0;

import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import c.a.e.a.f;
import c.a.e.e.p.l;
import c.a.e.e.p.q;
import c.a.p0.t.c.v;
import c.a.q0.i2.k.e.z0.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.EmotionUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.img.GetEmotionPidModel;
import com.baidu.tieba.R;
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
/* loaded from: classes3.dex */
public class c implements QueryMatchEmotionModel.b, b.InterfaceC0930b, EmotionView.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public f f19767e;

    /* renamed from: f  reason: collision with root package name */
    public List<String> f19768f;

    /* renamed from: g  reason: collision with root package name */
    public HListView f19769g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.q0.i2.k.e.z0.b f19770h;

    /* renamed from: i  reason: collision with root package name */
    public QueryMatchEmotionModel f19771i;

    /* renamed from: j  reason: collision with root package name */
    public String f19772j;
    public Handler k;
    public ViewGroup l;
    public ViewGroup.LayoutParams m;
    public EditorTools n;
    public GetEmotionPidModel o;
    public Runnable p;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f19773e;

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
            this.f19773e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19773e.f19772j = "";
                this.f19773e.f19769g.setVisibility(8);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements AbsHListView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f19774a;

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
            this.f19774a = cVar;
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
                    this.f19774a.k.removeCallbacks(this.f19774a.p);
                    this.f19774a.k.postDelayed(this.f19774a.p, 5000L);
                } else if (i2 != 1) {
                } else {
                    this.f19774a.k.removeCallbacks(this.f19774a.p);
                }
            }
        }
    }

    /* renamed from: c.a.q0.i2.k.e.z0.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0931c implements GetEmotionPidModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionImageData f19775a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f19776b;

        public C0931c(c cVar, EmotionImageData emotionImageData) {
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
            this.f19776b = cVar;
            this.f19775a = emotionImageData;
        }

        @Override // com.baidu.tbadk.img.GetEmotionPidModel.b
        public void a(c.a.p0.c0.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null || TextUtils.isEmpty(cVar.f12974a)) {
                return;
            }
            this.f19775a.setPicId(cVar.f12974a);
            this.f19776b.j(this.f19775a);
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
        this.f19767e = fVar;
        this.l = viewGroup;
        this.m = layoutParams;
        this.k = new Handler();
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.b
    public void a(String str, List<EmotionImageData> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) && !TextUtils.isEmpty(str) && str.equals(this.f19772j)) {
            if (ListUtils.isEmpty(list)) {
                this.f19772j = "";
            } else if (this.l == null || this.m == null) {
            } else {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                HListView hListView = this.f19769g;
                if (hListView == null || hListView.getParent() == null) {
                    HListView hListView2 = new HListView(this.f19767e.getContext());
                    this.f19769g = hListView2;
                    SkinManager.setBackgroundColor(hListView2, R.color.CAM_X0201);
                    this.f19769g.setDividerWidth(l.g(this.f19767e.getPageActivity(), R.dimen.ds7));
                    this.f19769g.setClipToPadding(false);
                    int g2 = l.g(this.f19767e.getPageActivity(), R.dimen.ds10);
                    this.f19769g.setPadding(g2, g2, g2, g2);
                    this.f19769g.setSelector(R.drawable.list_selector_transparent);
                    this.m.height = l.g(this.f19767e.getPageActivity(), R.dimen.ds136);
                    this.l.addView(this.f19769g, this.m);
                    if (this.f19770h == null) {
                        c.a.q0.i2.k.e.z0.b bVar = new c.a.q0.i2.k.e.z0.b();
                        this.f19770h = bVar;
                        bVar.d(this);
                        this.f19770h.c(this);
                        this.f19769g.setAdapter((ListAdapter) this.f19770h);
                        this.f19769g.setOnScrollListener(new b(this));
                    }
                }
                this.f19769g.setVisibility(0);
                this.f19770h.b(list);
                this.f19770h.notifyDataSetChanged();
                this.f19769g.setSelection(0);
                this.k.removeCallbacks(this.p);
                this.k.postDelayed(this.p, 5000L);
            }
        }
    }

    @Override // c.a.q0.i2.k.e.z0.b.InterfaceC0930b
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
            this.o.x(emotionImageData.getPicUrl(), new C0931c(this, emotionImageData));
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
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (queryMatchEmotionModel = this.f19771i) == null) {
            return;
        }
        queryMatchEmotionModel.cancelLoadData();
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            HListView hListView = this.f19769g;
            if (hListView != null) {
                hListView.setVisibility(8);
            }
            this.k.removeCallbacks(this.p);
            this.f19772j = "";
        }
    }

    public final void j(EmotionImageData emotionImageData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, emotionImageData) == null) {
            TiebaStatic.log("c12489");
            v vVar = new v();
            StringBuilder sb = new StringBuilder();
            sb.append(emotionImageData.getPicId());
            sb.append(",");
            sb.append(emotionImageData.getWidth());
            sb.append(",");
            sb.append(emotionImageData.getHeight());
            sb.append(",");
            String lowerCase = q.c(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX_SHORT + sb.toString() + "7S6wbXjEKL9N").toLowerCase();
            vVar.k("#(meme,net_" + Uri.encode(emotionImageData.getPicUrl()) + "," + sb.toString() + lowerCase + SmallTailInfo.EMOTION_SUFFIX);
            vVar.n(EmotionGroupType.NET_SUG);
            vVar.p(emotionImageData.getWidth());
            vVar.j(emotionImageData.getHeight());
            vVar.o(emotionImageData.getPicUrl());
            this.n.sendAction(new c.a.p0.x.a(24, -1, vVar));
        }
    }

    public final void k(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || TextUtils.isEmpty(str) || str.equals(this.f19772j)) {
            return;
        }
        this.f19772j = str;
        if (this.f19771i == null) {
            this.f19771i = new QueryMatchEmotionModel(this.f19767e);
        }
        this.f19771i.z(str, this);
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || TextUtils.isEmpty(str) || ListUtils.isEmpty(this.f19768f) || !this.f19768f.contains(str)) {
            return;
        }
        k(str);
    }

    public void m(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.f19768f = list;
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
