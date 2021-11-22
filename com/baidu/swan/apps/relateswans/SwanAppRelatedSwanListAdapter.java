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
import b.a.p0.a.b2.a;
import b.a.p0.a.d2.d;
import b.a.p0.a.e;
import b.a.p0.a.f;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.g;
import b.a.p0.a.n2.n;
import b.a.p0.a.z2.t;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.view.SwanAppRoundedImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class SwanAppRelatedSwanListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PAGE_ABOUT_MORE_RELATED_SWAN = "more";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f44725a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.p0.a.b2.a f44726b;

    /* loaded from: classes8.dex */
    public static class a extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.swan.apps.relateswans.SwanAppRelatedSwanListAdapter$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class View$OnClickListenerC1730a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f44727e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f44728f;

            public View$OnClickListenerC1730a(a aVar, Context context, String str) {
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
                this.f44727e = context;
                this.f44728f = str;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    SchemeRouter.invoke(this.f44727e, this.f44728f);
                    SwanAppRelatedSwanListAdapter.doUBCEventStatistic("aboutrelated", "more", PrefetchEvent.STATE_CLICK);
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
                textView.setOnClickListener(new View$OnClickListenerC1730a(this, context, str));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes8.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a.C0123a f44729e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Context f44730f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f44731g;

            public a(b bVar, a.C0123a c0123a, Context context, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, c0123a, context, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f44729e = c0123a;
                this.f44730f = context;
                this.f44731g = i2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.f44729e.f4157c)) {
                    return;
                }
                SchemeRouter.invoke(this.f44730f, this.f44729e.f4157c);
                SwanAppRelatedSwanListAdapter.doUBCEventStatistic("aboutrelated", String.valueOf(this.f44731g), PrefetchEvent.STATE_CLICK);
            }
        }

        /* renamed from: com.baidu.swan.apps.relateswans.SwanAppRelatedSwanListAdapter$b$b  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C1731b implements t.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ SwanAppRoundedImageView f44732a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f44733b;

            public C1731b(b bVar, SwanAppRoundedImageView swanAppRoundedImageView, Context context) {
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
                this.f44732a = swanAppRoundedImageView;
                this.f44733b = context;
            }

            @Override // b.a.p0.a.z2.t.b
            public void a(String str, Bitmap bitmap) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) {
                    if (bitmap == null) {
                        this.f44732a.setImageDrawable(this.f44733b.getResources().getDrawable(e.aiapps_default_grey_icon));
                    } else {
                        this.f44732a.setImageBitmap(bitmap);
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

        public void a(Context context, a.C0123a c0123a, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048576, this, context, c0123a, i2) == null) || c0123a == null) {
                return;
            }
            ((RelativeLayout) this.itemView.findViewById(f.related_swan_app)).setOnClickListener(new a(this, c0123a, context, i2));
            t.e(c0123a.f4155a, new C1731b(this, (SwanAppRoundedImageView) this.itemView.findViewById(f.swan_app_icon), context));
            ((TextView) this.itemView.findViewById(f.swan_app_name)).setText(c0123a.f4156b);
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
                this((Context) objArr2[0], (b.a.p0.a.b2.a) objArr2[1]);
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
        b.a.p0.a.n2.s.f fVar = new b.a.p0.a.n2.s.f();
        fVar.f7383e = str;
        if (!TextUtils.isEmpty(str2)) {
            fVar.a("page", str2);
            fVar.f7385g = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            fVar.f7380b = str3;
        }
        b.a V = d.J().r().V();
        fVar.f7379a = n.n(d.J().l());
        fVar.f7384f = V.H();
        fVar.f7381c = V.T();
        fVar.b(n.k(V.W()));
        fVar.d(V.s0().getString(UBCCloudControlProcessor.UBC_KEY));
        b.a.p0.a.n2.d.b(fVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            b.a.p0.a.b2.a aVar = this.f44726b;
            if (aVar == null) {
                return 0;
            }
            return aVar.f4153a.size() + 1;
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
        b.a.p0.a.b2.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewHolder, i2) == null) || (aVar = this.f44726b) == null) {
            return;
        }
        if (!(viewHolder instanceof b)) {
            if (viewHolder instanceof a) {
                ((a) viewHolder).a(this.f44725a, aVar.f4154b);
                return;
            }
            return;
        }
        int i3 = i2 - 1;
        if (i3 < 0) {
            return;
        }
        ((b) viewHolder).a(this.f44725a, aVar.f4153a.get(i3), i2);
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

    public void updateData(b.a.p0.a.b2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.f44726b = aVar;
            notifyDataSetChanged();
        }
    }

    public SwanAppRelatedSwanListAdapter(Context context, b.a.p0.a.b2.a aVar) {
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
        this.f44725a = context;
        this.f44726b = aVar;
    }
}
