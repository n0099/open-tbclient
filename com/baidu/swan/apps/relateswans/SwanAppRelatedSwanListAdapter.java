package com.baidu.swan.apps.relateswans;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import c.a.p0.a.b2.a;
import c.a.p0.a.d2.d;
import c.a.p0.a.e;
import c.a.p0.a.f;
import c.a.p0.a.f1.e.b;
import c.a.p0.a.g;
import c.a.p0.a.n2.n;
import c.a.p0.a.z2.t;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.swan.apps.view.SwanAppRoundedImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class SwanAppRelatedSwanListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PAGE_ABOUT_MORE_RELATED_SWAN = "more";
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.a.b2.a f39731b;

    /* loaded from: classes9.dex */
    public static class a extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.swan.apps.relateswans.SwanAppRelatedSwanListAdapter$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class View$OnClickListenerC1800a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f39732e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f39733f;

            public View$OnClickListenerC1800a(a aVar, Context context, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, context, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f39732e = context;
                this.f39733f = str;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    SchemeRouter.invoke(this.f39732e, this.f39733f);
                    SwanAppRelatedSwanListAdapter.doUBCEventStatistic("aboutrelated", "more", "click");
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public void a(Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, str) == null) {
                TextView textView = (TextView) this.itemView.findViewById(f.more_relate_swan_app);
                if (TextUtils.isEmpty(str)) {
                    textView.setVisibility(8);
                    return;
                }
                textView.setVisibility(0);
                textView.setOnClickListener(new View$OnClickListenerC1800a(this, context, str));
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes9.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a.C0179a f39734e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Context f39735f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f39736g;

            public a(b bVar, a.C0179a c0179a, Context context, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, c0179a, context, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f39734e = c0179a;
                this.f39735f = context;
                this.f39736g = i2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.f39734e.f4345c)) {
                    return;
                }
                SchemeRouter.invoke(this.f39735f, this.f39734e.f4345c);
                SwanAppRelatedSwanListAdapter.doUBCEventStatistic("aboutrelated", String.valueOf(this.f39736g), "click");
            }
        }

        /* renamed from: com.baidu.swan.apps.relateswans.SwanAppRelatedSwanListAdapter$b$b  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C1801b implements t.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SwanAppRoundedImageView a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f39737b;

            public C1801b(b bVar, SwanAppRoundedImageView swanAppRoundedImageView, Context context) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, swanAppRoundedImageView, context};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = swanAppRoundedImageView;
                this.f39737b = context;
            }

            @Override // c.a.p0.a.z2.t.b
            public void a(String str, Bitmap bitmap) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) {
                    if (bitmap == null) {
                        this.a.setImageDrawable(this.f39737b.getResources().getDrawable(e.aiapps_default_grey_icon));
                    } else {
                        this.a.setImageBitmap(bitmap);
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public void a(Context context, a.C0179a c0179a, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048576, this, context, c0179a, i2) == null) || c0179a == null) {
                return;
            }
            ((RelativeLayout) this.itemView.findViewById(f.related_swan_app)).setOnClickListener(new a(this, c0179a, context, i2));
            t.e(c0179a.a, new C1801b(this, (SwanAppRoundedImageView) this.itemView.findViewById(f.swan_app_icon), context));
            ((TextView) this.itemView.findViewById(f.swan_app_name)).setText(c0179a.f4344b);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SwanAppRelatedSwanListAdapter(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (c.a.p0.a.b2.a) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void doUBCEventStatistic(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, str, str2, str3) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        c.a.p0.a.n2.s.f fVar = new c.a.p0.a.n2.s.f();
        fVar.f7116e = str;
        if (!TextUtils.isEmpty(str2)) {
            fVar.a("page", str2);
            fVar.f7118g = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            fVar.f7113b = str3;
        }
        b.a V = d.J().r().V();
        fVar.a = n.n(d.J().l());
        fVar.f7117f = V.H();
        fVar.f7114c = V.T();
        fVar.b(n.k(V.W()));
        fVar.d(V.s0().getString(UBCCloudControlProcessor.UBC_KEY));
        c.a.p0.a.n2.d.b(fVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c.a.p0.a.b2.a aVar = this.f39731b;
            if (aVar == null) {
                return 0;
            }
            return aVar.a.size() + 1;
        }
        return invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? i2 == 0 ? 0 : 1 : invokeI.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        c.a.p0.a.b2.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewHolder, i2) == null) || (aVar = this.f39731b) == null) {
            return;
        }
        if (!(viewHolder instanceof b)) {
            if (viewHolder instanceof a) {
                ((a) viewHolder).a(this.a, aVar.f4343b);
                return;
            }
            return;
        }
        int i3 = i2 - 1;
        if (i3 < 0) {
            return;
        }
        ((b) viewHolder).a(this.a, aVar.a.get(i3), i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, viewGroup, i2)) == null) {
            if (i2 == 0) {
                return new a(LayoutInflater.from(viewGroup.getContext()).inflate(g.swan_app_related_swan_head_item, viewGroup, false));
            }
            return new b(LayoutInflater.from(viewGroup.getContext()).inflate(g.swan_app_related_swan_item, viewGroup, false));
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }

    public void updateData(c.a.p0.a.b2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.f39731b = aVar;
            notifyDataSetChanged();
        }
    }

    public SwanAppRelatedSwanListAdapter(Context context, c.a.p0.a.b2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = context;
        this.f39731b = aVar;
    }
}
