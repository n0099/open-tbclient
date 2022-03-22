package com.baidu.card.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.n;
import c.a.o0.m.f;
import c.a.o0.r.r.n1;
import c.a.o0.r.r.o;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class HorizontalRecommendForumAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<c.a.o0.k0.b.a> f25017b;

    /* renamed from: c  reason: collision with root package name */
    public f<n1> f25018c;

    /* loaded from: classes3.dex */
    public class a extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f25019b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f25020c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f25021d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f25022e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HorizontalRecommendForumAdapter f25023f;

        /* renamed from: com.baidu.card.adapter.HorizontalRecommendForumAdapter$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class View$OnClickListenerC1742a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public View$OnClickListenerC1742a(a aVar, HorizontalRecommendForumAdapter horizontalRecommendForumAdapter) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, horizontalRecommendForumAdapter};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.f25023f.f25018c == null) {
                    return;
                }
                int adapterPosition = this.a.getAdapterPosition();
                this.a.f25023f.f25018c.a(view, null, adapterPosition, adapterPosition);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(HorizontalRecommendForumAdapter horizontalRecommendForumAdapter, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizontalRecommendForumAdapter, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25023f = horizontalRecommendForumAdapter;
            this.a = view;
            TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f029b);
            this.f25019b = (BarImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090a4a);
            this.f25020c = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f091d7c);
            this.f25021d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090a67);
            this.f25022e = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090777);
            this.a.setOnClickListener(new View$OnClickListenerC1742a(this, horizontalRecommendForumAdapter));
        }

        public void a(o oVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, oVar) == null) || oVar == null) {
                return;
            }
            this.f25020c.setVisibility(0);
            this.f25019b.setVisibility(8);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f25020c, R.drawable.obfuscated_res_0x7f080614, null);
            this.f25021d.setText(R.string.obfuscated_res_0x7f0f06a4);
            this.f25022e.setText(R.string.obfuscated_res_0x7f0f06a1);
            b();
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SkinManager.setViewTextColor(this.f25021d, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f25022e, (int) R.color.CAM_X0109);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f25024b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f25025c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f25026d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f25027e;

        /* renamed from: f  reason: collision with root package name */
        public n1 f25028f;

        /* renamed from: g  reason: collision with root package name */
        public String f25029g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ HorizontalRecommendForumAdapter f25030h;

        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar, HorizontalRecommendForumAdapter horizontalRecommendForumAdapter) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, horizontalRecommendForumAdapter};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.f25030h.f25018c == null) {
                    return;
                }
                int adapterPosition = this.a.getAdapterPosition();
                this.a.f25030h.f25018c.a(view, this.a.f25028f, adapterPosition, adapterPosition);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(HorizontalRecommendForumAdapter horizontalRecommendForumAdapter, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizontalRecommendForumAdapter, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25030h = horizontalRecommendForumAdapter;
            this.a = view;
            this.f25029g = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f029b);
            this.f25024b = (BarImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090a4a);
            this.f25025c = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f091d7c);
            this.f25026d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090a67);
            this.f25027e = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090777);
            this.a.setOnClickListener(new a(this, horizontalRecommendForumAdapter));
        }

        public void b(n1 n1Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, n1Var) == null) || n1Var == null) {
                return;
            }
            this.f25028f = n1Var;
            this.f25024b.setShowOval(true);
            this.f25024b.setShowOuterBorder(false);
            this.f25024b.setShowInnerBorder(true);
            this.f25024b.setStrokeWith(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.f25024b.setStrokeColorResId(R.color.CAM_X0401);
            this.f25025c.setVisibility(8);
            this.f25024b.setVisibility(0);
            this.f25024b.J(n1Var.i(), 10, false);
            if (StringHelper.getChineseAndEnglishLength(n1Var.m()) <= 10) {
                this.f25026d.setText(n1Var.m());
            } else {
                this.f25026d.setText(StringHelper.cutChineseAndEnglishWithSuffix(n1Var.m(), 8, StringHelper.STRING_MORE));
            }
            this.f25027e.setText(this.f25029g + " " + StringHelper.numFormatOverWanWithoutDecimals(n1Var.q()));
            c();
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SkinManager.setViewTextColor(this.f25026d, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f25027e, (int) R.color.CAM_X0109);
            }
        }
    }

    public HorizontalRecommendForumAdapter(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f25017b = new ArrayList<>();
        this.a = tbPageContext;
    }

    public void e(ArrayList<? extends c.a.o0.k0.b.a> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, arrayList) == null) || arrayList == null) {
            return;
        }
        this.f25017b.clear();
        this.f25017b.addAll(arrayList);
        notifyDataSetChanged();
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
        }
    }

    public void g(f<n1> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) {
            this.f25018c = fVar;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList<c.a.o0.k0.b.a> arrayList = this.f25017b;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            if (this.f25017b.get(i) instanceof n1) {
                return 1;
            }
            return this.f25017b.get(i) instanceof o ? 2 : 0;
        }
        return invokeI.intValue;
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ArrayList<c.a.o0.k0.b.a> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, viewHolder, i) == null) || (arrayList = this.f25017b) == null || arrayList.size() <= 0) {
            return;
        }
        c.a.o0.k0.b.a aVar = this.f25017b.get(i);
        if ((viewHolder instanceof a) && (aVar instanceof o)) {
            ((a) viewHolder).a((o) aVar);
        } else if ((viewHolder instanceof b) && (aVar instanceof n1)) {
            n1 n1Var = (n1) aVar;
            ((b) viewHolder).b(n1Var);
            f<n1> fVar = this.f25018c;
            if (fVar != null) {
                fVar.c(viewHolder.itemView, n1Var, i, i);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, viewGroup, i)) == null) {
            View inflate = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0721, (ViewGroup) null);
            if (i == 2) {
                return new a(this, inflate);
            }
            return new b(this, inflate);
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }
}
