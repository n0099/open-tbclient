package c.a.p0.w2.m.f.j1;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes3.dex */
public class d extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public List<EmotionImageData> f20144b;

    /* renamed from: c  reason: collision with root package name */
    public Set<String> f20145c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.w2.m.f.j1.a f20146d;

    /* renamed from: e  reason: collision with root package name */
    public int f20147e;

    /* renamed from: f  reason: collision with root package name */
    public int f20148f;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f20149g;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (tag = view.getTag(view.getId())) != null && (tag instanceof EmotionImageData)) {
                if (this.a.f20146d != null && (view instanceof EmotionView)) {
                    this.a.f20146d.a((EmotionImageData) tag, ((EmotionView) view).getIsGif());
                }
                TiebaStatic.log("c12180");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Void, Void, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                if (this.a.f20145c != null) {
                    for (String str : this.a.f20145c) {
                        if (!TextUtils.isEmpty(str)) {
                            c.a.o0.b0.c.k().h(str);
                        }
                    }
                    return Boolean.TRUE;
                }
                return Boolean.TRUE;
            }
            return (Boolean) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public EmotionView a;

        /* renamed from: b  reason: collision with root package name */
        public EmotionView f20150b;

        /* renamed from: c  reason: collision with root package name */
        public EmotionView f20151c;

        /* renamed from: d  reason: collision with root package name */
        public EmotionView f20152d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f20153e;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20153e = dVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f20153e.e(this.a);
                this.f20153e.e(this.f20150b);
                this.f20153e.e(this.f20151c);
                this.f20153e.e(this.f20152d);
            }
        }
    }

    public d(List<EmotionImageData> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = BdBaseApplication.getInst().getApp();
        this.f20144b = list;
        this.f20145c = new HashSet();
        this.f20148f = n.f(this.a, R.dimen.obfuscated_res_0x7f070231);
        this.f20147e = (int) (((n.k(this.a) - n.f(this.a, R.dimen.obfuscated_res_0x7f0702ff)) - (this.f20148f * 4)) * 0.333d);
    }

    public final void d(EmotionView emotionView, EmotionImageData emotionImageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, emotionView, emotionImageData) == null) || emotionView == null || emotionImageData == null) {
            return;
        }
        emotionView.setTag(emotionView.getId(), emotionImageData);
        emotionView.j0();
        emotionView.l0(emotionImageData);
        if (this.f20145c == null || TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            return;
        }
        if (ListUtils.isEmpty(this.f20149g) || !this.f20149g.contains(emotionImageData.getThumbUrl())) {
            Set<String> set = this.f20145c;
            set.add(emotionImageData.getThumbUrl() + emotionView.getLoadProcType());
        }
    }

    public final void e(EmotionView emotionView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, emotionView) == null) || emotionView == null) {
            return;
        }
        emotionView.setOnClickListener(new a(this));
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            new b(this).execute(new Void[0]);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f20146d = null;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f20144b.size() % 4 == 0) {
                return this.f20144b.size() / 4;
            }
            return (this.f20144b.size() / 4) + 1;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? this.f20144b.get(i) : invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i, view, viewGroup)) == null) {
            if (view == null) {
                c cVar2 = new c(this);
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0508, (ViewGroup) null);
                cVar2.a = (EmotionView) inflate.findViewById(R.id.obfuscated_res_0x7f0908b6);
                cVar2.f20150b = (EmotionView) inflate.findViewById(R.id.obfuscated_res_0x7f0908b7);
                cVar2.f20151c = (EmotionView) inflate.findViewById(R.id.obfuscated_res_0x7f0908b8);
                cVar2.f20152d = (EmotionView) inflate.findViewById(R.id.obfuscated_res_0x7f0908b9);
                cVar2.a();
                i(cVar2.f20150b, this.f20147e);
                i(cVar2.f20151c, this.f20147e);
                i(cVar2.f20152d, this.f20147e);
                inflate.setTag(cVar2);
                cVar = cVar2;
                view = inflate;
            } else {
                cVar = (c) view.getTag();
            }
            int i2 = i * 4;
            int i3 = i2 + 4;
            int min = Math.min(i3, this.f20144b.size() - 1);
            for (int i4 = i2; i4 < i3; i4++) {
                if (i4 <= min) {
                    EmotionImageData emotionImageData = this.f20144b.get(i4);
                    int i5 = i4 - i2;
                    if (i5 == 0) {
                        d(cVar.a, emotionImageData);
                    } else if (i5 == 1) {
                        d(cVar.f20150b, emotionImageData);
                    } else if (i5 == 2) {
                        d(cVar.f20151c, emotionImageData);
                    } else if (i5 == 3) {
                        d(cVar.f20152d, emotionImageData);
                    }
                }
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }

    public void h(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            this.f20149g = list;
        }
    }

    public final void i(View view, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048585, this, view, i) == null) || view == null || view.getLayoutParams() == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.leftMargin = i;
        view.setLayoutParams(marginLayoutParams);
    }

    public void j(c.a.p0.w2.m.f.j1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            this.f20146d = aVar;
        }
    }
}
