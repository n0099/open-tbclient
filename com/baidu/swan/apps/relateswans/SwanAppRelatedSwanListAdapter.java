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
import c.a.p0.a.a2.d;
import c.a.p0.a.e;
import c.a.p0.a.f;
import c.a.p0.a.f1.e.b;
import c.a.p0.a.g;
import c.a.p0.a.j2.k;
import c.a.p0.a.v2.t;
import c.a.p0.a.y1.a;
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
/* loaded from: classes6.dex */
public class SwanAppRelatedSwanListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PAGE_ABOUT_MORE_RELATED_SWAN = "more";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f46237a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.a.y1.a f46238b;

    /* loaded from: classes6.dex */
    public static class a extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.swan.apps.relateswans.SwanAppRelatedSwanListAdapter$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class View$OnClickListenerC1736a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f46239e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f46240f;

            public View$OnClickListenerC1736a(a aVar, Context context, String str) {
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
                this.f46239e = context;
                this.f46240f = str;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    SchemeRouter.invoke(this.f46239e, this.f46240f);
                    SwanAppRelatedSwanListAdapter.doUBCEventStatistic("aboutrelated", SwanAppRelatedSwanListAdapter.PAGE_ABOUT_MORE_RELATED_SWAN, PrefetchEvent.STATE_CLICK);
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
                textView.setOnClickListener(new View$OnClickListenerC1736a(this, context, str));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes6.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a.C0473a f46241e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Context f46242f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f46243g;

            public a(b bVar, a.C0473a c0473a, Context context, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, c0473a, context, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f46241e = c0473a;
                this.f46242f = context;
                this.f46243g = i2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.f46241e.f9856c)) {
                    return;
                }
                SchemeRouter.invoke(this.f46242f, this.f46241e.f9856c);
                SwanAppRelatedSwanListAdapter.doUBCEventStatistic("aboutrelated", String.valueOf(this.f46243g), PrefetchEvent.STATE_CLICK);
            }
        }

        /* renamed from: com.baidu.swan.apps.relateswans.SwanAppRelatedSwanListAdapter$b$b  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C1737b implements t.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ SwanAppRoundedImageView f46244a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f46245b;

            public C1737b(b bVar, SwanAppRoundedImageView swanAppRoundedImageView, Context context) {
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
                this.f46244a = swanAppRoundedImageView;
                this.f46245b = context;
            }

            @Override // c.a.p0.a.v2.t.b
            public void a(String str, Bitmap bitmap) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) {
                    if (bitmap == null) {
                        this.f46244a.setImageDrawable(this.f46245b.getResources().getDrawable(e.aiapps_default_grey_icon));
                    } else {
                        this.f46244a.setImageBitmap(bitmap);
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

        public void a(Context context, a.C0473a c0473a, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048576, this, context, c0473a, i2) == null) || c0473a == null) {
                return;
            }
            ((RelativeLayout) this.itemView.findViewById(f.related_swan_app)).setOnClickListener(new a(this, c0473a, context, i2));
            t.e(c0473a.f9854a, new C1737b(this, (SwanAppRoundedImageView) this.itemView.findViewById(f.swan_app_icon), context));
            ((TextView) this.itemView.findViewById(f.swan_app_name)).setText(c0473a.f9855b);
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
                this((Context) objArr2[0], (c.a.p0.a.y1.a) objArr2[1]);
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
        c.a.p0.a.j2.p.f fVar = new c.a.p0.a.j2.p.f();
        fVar.f7075e = str;
        if (!TextUtils.isEmpty(str2)) {
            fVar.a("page", str2);
            fVar.f7077g = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            fVar.f7072b = str3;
        }
        b.a L = d.g().r().L();
        fVar.f7071a = k.m(d.g().l());
        fVar.f7076f = L.H();
        fVar.f7073c = L.T();
        fVar.b(k.k(L.W()));
        fVar.d(L.r0().getString(UBCCloudControlProcessor.UBC_KEY));
        c.a.p0.a.j2.d.b(fVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c.a.p0.a.y1.a aVar = this.f46238b;
            if (aVar == null) {
                return 0;
            }
            return aVar.f9852a.size() + 1;
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
        c.a.p0.a.y1.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewHolder, i2) == null) || (aVar = this.f46238b) == null) {
            return;
        }
        if (!(viewHolder instanceof b)) {
            if (viewHolder instanceof a) {
                ((a) viewHolder).a(this.f46237a, aVar.f9853b);
                return;
            }
            return;
        }
        int i3 = i2 - 1;
        if (i3 < 0) {
            return;
        }
        ((b) viewHolder).a(this.f46237a, aVar.f9852a.get(i3), i2);
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

    public void updateData(c.a.p0.a.y1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.f46238b = aVar;
            notifyDataSetChanged();
        }
    }

    public SwanAppRelatedSwanListAdapter(Context context, c.a.p0.a.y1.a aVar) {
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
        this.f46237a = context;
        this.f46238b = aVar;
    }
}
