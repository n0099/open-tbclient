package c.a.p0.r2.g;

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
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public List<EmotionImageData> f18044b;

    /* renamed from: c  reason: collision with root package name */
    public Set<String> f18045c;

    /* renamed from: d  reason: collision with root package name */
    public LinkedHashMap<String, EmotionImageData> f18046d;

    /* renamed from: e  reason: collision with root package name */
    public f f18047e;

    /* renamed from: f  reason: collision with root package name */
    public int f18048f;

    /* renamed from: g  reason: collision with root package name */
    public int f18049g;

    /* renamed from: h  reason: collision with root package name */
    public int f18050h;
    public final Runnable i;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PickEmotionView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f18051b;

        public a(h hVar, PickEmotionView pickEmotionView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, pickEmotionView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18051b = hVar;
            this.a = pickEmotionView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (tag = view.getTag(view.getId())) != null && (tag instanceof EmotionImageData)) {
                EmotionImageData emotionImageData = (EmotionImageData) tag;
                if (this.f18051b.f18046d.containsKey(emotionImageData.getPicUrl())) {
                    this.f18051b.f18046d.remove(emotionImageData.getPicUrl());
                    this.a.setChoosed(false);
                    if (this.f18051b.f18047e != null) {
                        this.f18051b.f18047e.onUnChoose();
                    }
                } else if (this.f18051b.f18047e != null) {
                    if (this.f18051b.f18047e.canChooseMore()) {
                        this.f18051b.f18046d.put(emotionImageData.getPicUrl(), emotionImageData);
                        this.a.setChoosed(true);
                        this.f18051b.f18047e.onChoose();
                        return;
                    }
                    BdToast.c(this.f18051b.a, this.f18051b.a.getText(R.string.obfuscated_res_0x7f0f05ca)).q();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        public b(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f18045c == null) {
                return;
            }
            HashSet hashSet = new HashSet();
            Iterator it = this.a.f18046d.entrySet().iterator();
            while (it.hasNext()) {
                hashSet.add(((EmotionImageData) ((Map.Entry) it.next()).getValue()).getThumbUrl() + this.a.f18050h);
            }
            for (String str : this.a.f18045c) {
                if (!TextUtils.isEmpty(str) && !hashSet.contains(str)) {
                    c.a.o0.b0.c.k().h(str);
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
        public PickEmotionView f18052b;

        /* renamed from: c  reason: collision with root package name */
        public PickEmotionView f18053c;

        /* renamed from: d  reason: collision with root package name */
        public PickEmotionView f18054d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f18055e;

        public c(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18055e = hVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f18055e.j(this.a);
                this.f18055e.j(this.f18052b);
                this.f18055e.j(this.f18053c);
                this.f18055e.j(this.f18054d);
            }
        }
    }

    public h(List<EmotionImageData> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new b(this);
        this.a = BdBaseApplication.getInst().getApp();
        this.f18044b = list;
        this.f18050h = i;
        this.f18045c = new HashSet();
        this.f18046d = new LinkedHashMap<>();
        this.f18049g = n.f(this.a, R.dimen.obfuscated_res_0x7f070231);
        this.f18048f = (int) (((n.k(this.a) - n.f(this.a, R.dimen.obfuscated_res_0x7f070253)) - (this.f18049g * 4)) * 0.333d);
    }

    public void g(Map<String, EmotionImageData> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
            this.f18046d.putAll(map);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<EmotionImageData> list = this.f18044b;
            if (list != null) {
                if (list.size() % 4 == 0) {
                    return this.f18044b.size() / 4;
                }
                return (this.f18044b.size() / 4) + 1;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            List<EmotionImageData> list = this.f18044b;
            if (list == null || i > list.size() - 1) {
                return null;
            }
            return this.f18044b.get(i);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i, view, viewGroup)) == null) {
            if (view == null) {
                c cVar2 = new c(this);
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d04ff, (ViewGroup) null);
                cVar2.a = (PickEmotionView) inflate.findViewById(R.id.obfuscated_res_0x7f0908b6);
                cVar2.f18052b = (PickEmotionView) inflate.findViewById(R.id.obfuscated_res_0x7f0908b7);
                cVar2.f18053c = (PickEmotionView) inflate.findViewById(R.id.obfuscated_res_0x7f0908b8);
                cVar2.f18054d = (PickEmotionView) inflate.findViewById(R.id.obfuscated_res_0x7f0908b9);
                cVar2.a();
                n(cVar2.f18052b, this.f18048f);
                n(cVar2.f18053c, this.f18048f);
                n(cVar2.f18054d, this.f18048f);
                inflate.setTag(cVar2);
                cVar = cVar2;
                view = inflate;
            } else {
                cVar = (c) view.getTag();
            }
            int i2 = i * 4;
            int i3 = i2 + 4;
            int min = Math.min(i3, this.f18044b.size() - 1);
            int i4 = i2;
            while (i4 < i3) {
                EmotionImageData emotionImageData = i4 <= min ? this.f18044b.get(i4) : null;
                int i5 = i4 - i2;
                if (i5 == 0) {
                    h(cVar.a, emotionImageData);
                } else if (i5 == 1) {
                    h(cVar.f18052b, emotionImageData);
                } else if (i5 == 2) {
                    h(cVar.f18053c, emotionImageData);
                } else if (i5 == 3) {
                    h(cVar.f18054d, emotionImageData);
                }
                i4++;
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
        pickEmotionView.setData(emotionImageData, this.f18050h);
        m(pickEmotionView, emotionImageData);
        if (this.f18045c == null || TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            return;
        }
        Set<String> set = this.f18045c;
        set.add(emotionImageData.getThumbUrl() + pickEmotionView.getLoadType());
    }

    public LinkedHashMap<String, EmotionImageData> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f18046d : (LinkedHashMap) invokeV.objValue;
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
            new Thread(this.i).start();
        }
    }

    public void l(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, fVar) == null) {
            this.f18047e = fVar;
        }
    }

    public final void m(PickEmotionView pickEmotionView, EmotionImageData emotionImageData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, pickEmotionView, emotionImageData) == null) {
            if (this.f18046d.containsKey(emotionImageData.getPicUrl())) {
                pickEmotionView.setChoosed(true);
            } else {
                pickEmotionView.setChoosed(false);
            }
        }
    }

    public final void n(View view, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048587, this, view, i) == null) || view == null || view.getLayoutParams() == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.leftMargin = i;
        view.setLayoutParams(marginLayoutParams);
    }
}
