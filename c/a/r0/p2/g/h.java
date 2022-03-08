package c.a.r0.p2.g;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.newfaceshop.facemake.PickEmotionView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public class h extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f20844e;

    /* renamed from: f  reason: collision with root package name */
    public List<EmotionImageData> f20845f;

    /* renamed from: g  reason: collision with root package name */
    public Set<String> f20846g;

    /* renamed from: h  reason: collision with root package name */
    public LinkedHashMap<String, EmotionImageData> f20847h;

    /* renamed from: i  reason: collision with root package name */
    public f f20848i;

    /* renamed from: j  reason: collision with root package name */
    public int f20849j;
    public int k;
    public int l;
    public final Runnable m;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PickEmotionView f20850e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h f20851f;

        public a(h hVar, PickEmotionView pickEmotionView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, pickEmotionView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20851f = hVar;
            this.f20850e = pickEmotionView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (tag = view.getTag(view.getId())) != null && (tag instanceof EmotionImageData)) {
                EmotionImageData emotionImageData = (EmotionImageData) tag;
                if (this.f20851f.f20847h.containsKey(emotionImageData.getPicUrl())) {
                    this.f20851f.f20847h.remove(emotionImageData.getPicUrl());
                    this.f20850e.setChoosed(false);
                    if (this.f20851f.f20848i != null) {
                        this.f20851f.f20848i.onUnChoose();
                    }
                } else if (this.f20851f.f20848i != null) {
                    if (this.f20851f.f20848i.canChooseMore()) {
                        this.f20851f.f20847h.put(emotionImageData.getPicUrl(), emotionImageData);
                        this.f20850e.setChoosed(true);
                        this.f20851f.f20848i.onChoose();
                        return;
                    }
                    BdToast.c(this.f20851f.f20844e, this.f20851f.f20844e.getText(R.string.face_group_add_pic_max)).q();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f20852e;

        public b(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20852e = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f20852e.f20846g == null) {
                return;
            }
            HashSet hashSet = new HashSet();
            Iterator it = this.f20852e.f20847h.entrySet().iterator();
            while (it.hasNext()) {
                hashSet.add(((EmotionImageData) ((Map.Entry) it.next()).getValue()).getThumbUrl() + this.f20852e.l);
            }
            for (String str : this.f20852e.f20846g) {
                if (!TextUtils.isEmpty(str) && !hashSet.contains(str)) {
                    c.a.q0.b0.c.k().h(str);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public PickEmotionView a;

        /* renamed from: b  reason: collision with root package name */
        public PickEmotionView f20853b;

        /* renamed from: c  reason: collision with root package name */
        public PickEmotionView f20854c;

        /* renamed from: d  reason: collision with root package name */
        public PickEmotionView f20855d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f20856e;

        public c(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20856e = hVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f20856e.j(this.a);
                this.f20856e.j(this.f20853b);
                this.f20856e.j(this.f20854c);
                this.f20856e.j(this.f20855d);
            }
        }
    }

    public h(List<EmotionImageData> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = new b(this);
        this.f20844e = BdBaseApplication.getInst().getApp();
        this.f20845f = list;
        this.l = i2;
        this.f20846g = new HashSet();
        this.f20847h = new LinkedHashMap<>();
        this.k = n.f(this.f20844e, R.dimen.ds116);
        this.f20849j = (int) (((n.k(this.f20844e) - n.f(this.f20844e, R.dimen.ds60)) - (this.k * 4)) * 0.333d);
    }

    public void g(Map<String, EmotionImageData> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
            this.f20847h.putAll(map);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<EmotionImageData> list = this.f20845f;
            if (list != null) {
                if (list.size() % 4 == 0) {
                    return this.f20845f.size() / 4;
                }
                return (this.f20845f.size() / 4) + 1;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            List<EmotionImageData> list = this.f20845f;
            if (list == null || i2 > list.size() - 1) {
                return null;
            }
            return this.f20845f.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                c cVar2 = new c(this);
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_emotion, (ViewGroup) null);
                cVar2.a = (PickEmotionView) inflate.findViewById(R.id.emotion_view1);
                cVar2.f20853b = (PickEmotionView) inflate.findViewById(R.id.emotion_view2);
                cVar2.f20854c = (PickEmotionView) inflate.findViewById(R.id.emotion_view3);
                cVar2.f20855d = (PickEmotionView) inflate.findViewById(R.id.emotion_view4);
                cVar2.a();
                n(cVar2.f20853b, this.f20849j);
                n(cVar2.f20854c, this.f20849j);
                n(cVar2.f20855d, this.f20849j);
                inflate.setTag(cVar2);
                cVar = cVar2;
                view = inflate;
            } else {
                cVar = (c) view.getTag();
            }
            int i3 = i2 * 4;
            int i4 = i3 + 4;
            int min = Math.min(i4, this.f20845f.size() - 1);
            int i5 = i3;
            while (i5 < i4) {
                EmotionImageData emotionImageData = i5 <= min ? this.f20845f.get(i5) : null;
                int i6 = i5 - i3;
                if (i6 == 0) {
                    h(cVar.a, emotionImageData);
                } else if (i6 == 1) {
                    h(cVar.f20853b, emotionImageData);
                } else if (i6 == 2) {
                    h(cVar.f20854c, emotionImageData);
                } else if (i6 == 3) {
                    h(cVar.f20855d, emotionImageData);
                }
                i5++;
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }

    public final void h(PickEmotionView pickEmotionView, EmotionImageData emotionImageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, pickEmotionView, emotionImageData) == null) || pickEmotionView == null) {
            return;
        }
        if (emotionImageData == null) {
            pickEmotionView.setVisibility(4);
            return;
        }
        pickEmotionView.getEmotionView().setTag(pickEmotionView.getEmotionView().getId(), emotionImageData);
        pickEmotionView.setData(emotionImageData, this.l);
        m(pickEmotionView, emotionImageData);
        if (this.f20846g == null || TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            return;
        }
        Set<String> set = this.f20846g;
        set.add(emotionImageData.getThumbUrl() + pickEmotionView.getLoadType());
    }

    public LinkedHashMap<String, EmotionImageData> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f20847h : (LinkedHashMap) invokeV.objValue;
    }

    public final void j(PickEmotionView pickEmotionView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, pickEmotionView) == null) || pickEmotionView == null) {
            return;
        }
        pickEmotionView.getEmotionView().setOnClickListener(new a(this, pickEmotionView));
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            new Thread(this.m).start();
        }
    }

    public void l(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, fVar) == null) {
            this.f20848i = fVar;
        }
    }

    public final void m(PickEmotionView pickEmotionView, EmotionImageData emotionImageData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, pickEmotionView, emotionImageData) == null) {
            if (this.f20847h.containsKey(emotionImageData.getPicUrl())) {
                pickEmotionView.setChoosed(true);
            } else {
                pickEmotionView.setChoosed(false);
            }
        }
    }

    public final void n(View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048587, this, view, i2) == null) || view == null || view.getLayoutParams() == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.leftMargin = i2;
        view.setLayoutParams(marginLayoutParams);
    }
}
