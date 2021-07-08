package com.baidu.card.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
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
import d.a.c.e.p.l;
import d.a.o0.m.f;
import d.a.o0.r.q.o;
import d.a.o0.r.q.o1;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class HorizontalRecommendForumAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f4379a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<d.a.o0.g0.b.a> f4380b;

    /* renamed from: c  reason: collision with root package name */
    public f<o1> f4381c;

    /* loaded from: classes.dex */
    public class a extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f4382a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f4383b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f4384c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f4385d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f4386e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HorizontalRecommendForumAdapter f4387f;

        /* renamed from: com.baidu.card.adapter.HorizontalRecommendForumAdapter$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class View$OnClickListenerC0084a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f4388e;

            public View$OnClickListenerC0084a(a aVar, HorizontalRecommendForumAdapter horizontalRecommendForumAdapter) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, horizontalRecommendForumAdapter};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f4388e = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f4388e.f4387f.f4381c == null) {
                    return;
                }
                int adapterPosition = this.f4388e.getAdapterPosition();
                this.f4388e.f4387f.f4381c.a(view, null, adapterPosition, adapterPosition);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4387f = horizontalRecommendForumAdapter;
            this.f4382a = view;
            TbadkCoreApplication.getInst().getString(R.string.attention);
            this.f4383b = (BarImageView) this.f4382a.findViewById(R.id.forum_icon);
            this.f4384c = (ImageView) this.f4382a.findViewById(R.id.square_icon);
            this.f4385d = (TextView) this.f4382a.findViewById(R.id.forum_name);
            this.f4386e = (TextView) this.f4382a.findViewById(R.id.desc);
            this.f4382a.setOnClickListener(new View$OnClickListenerC0084a(this, horizontalRecommendForumAdapter));
        }

        public void a(o oVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, oVar) == null) || oVar == null) {
                return;
            }
            this.f4384c.setVisibility(0);
            this.f4383b.setVisibility(8);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f4384c, R.drawable.ic_icon_pure_square28, null);
            this.f4385d.setText(R.string.forum_square_title);
            this.f4386e.setText(R.string.forum_square_desc_1);
            b();
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SkinManager.setViewTextColor(this.f4385d, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f4386e, R.color.CAM_X0109);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f4389a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f4390b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f4391c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f4392d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f4393e;

        /* renamed from: f  reason: collision with root package name */
        public o1 f4394f;

        /* renamed from: g  reason: collision with root package name */
        public String f4395g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ HorizontalRecommendForumAdapter f4396h;

        /* loaded from: classes.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f4397e;

            public a(b bVar, HorizontalRecommendForumAdapter horizontalRecommendForumAdapter) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, horizontalRecommendForumAdapter};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f4397e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f4397e.f4396h.f4381c == null) {
                    return;
                }
                int adapterPosition = this.f4397e.getAdapterPosition();
                this.f4397e.f4396h.f4381c.a(view, this.f4397e.f4394f, adapterPosition, adapterPosition);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4396h = horizontalRecommendForumAdapter;
            this.f4389a = view;
            this.f4395g = TbadkCoreApplication.getInst().getString(R.string.attention);
            this.f4390b = (BarImageView) this.f4389a.findViewById(R.id.forum_icon);
            this.f4391c = (ImageView) this.f4389a.findViewById(R.id.square_icon);
            this.f4392d = (TextView) this.f4389a.findViewById(R.id.forum_name);
            this.f4393e = (TextView) this.f4389a.findViewById(R.id.desc);
            this.f4389a.setOnClickListener(new a(this, horizontalRecommendForumAdapter));
        }

        public void b(o1 o1Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, o1Var) == null) || o1Var == null) {
                return;
            }
            this.f4394f = o1Var;
            this.f4390b.setShowOval(true);
            this.f4390b.setShowOuterBorder(false);
            this.f4390b.setShowInnerBorder(true);
            this.f4390b.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.f4390b.setStrokeColorResId(R.color.CAM_X0401);
            this.f4391c.setVisibility(8);
            this.f4390b.setVisibility(0);
            this.f4390b.M(o1Var.e(), 10, false);
            if (StringHelper.getChineseAndEnglishLength(o1Var.j()) <= 10) {
                this.f4392d.setText(o1Var.j());
            } else {
                this.f4392d.setText(StringHelper.cutChineseAndEnglishWithSuffix(o1Var.j(), 8, StringHelper.STRING_MORE));
            }
            this.f4393e.setText(this.f4395g + " " + StringHelper.numFormatOverWanWithoutDecimals(o1Var.o()));
            c();
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SkinManager.setViewTextColor(this.f4392d, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f4393e, R.color.CAM_X0109);
            }
        }
    }

    public HorizontalRecommendForumAdapter(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f4380b = new ArrayList<>();
        this.f4379a = tbPageContext;
    }

    public void e(ArrayList<? extends d.a.o0.g0.b.a> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, arrayList) == null) || arrayList == null) {
            return;
        }
        this.f4380b.clear();
        this.f4380b.addAll(arrayList);
        notifyDataSetChanged();
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
        }
    }

    public void g(f<o1> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) {
            this.f4381c = fVar;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList<d.a.o0.g0.b.a> arrayList = this.f4380b;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            if (this.f4380b.get(i2) instanceof o1) {
                return 1;
            }
            return this.f4380b.get(i2) instanceof o ? 2 : 0;
        }
        return invokeI.intValue;
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        ArrayList<d.a.o0.g0.b.a> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, viewHolder, i2) == null) || (arrayList = this.f4380b) == null || arrayList.size() <= 0) {
            return;
        }
        d.a.o0.g0.b.a aVar = this.f4380b.get(i2);
        if ((viewHolder instanceof a) && (aVar instanceof o)) {
            ((a) viewHolder).a((o) aVar);
        } else if ((viewHolder instanceof b) && (aVar instanceof o1)) {
            o1 o1Var = (o1) aVar;
            ((b) viewHolder).b(o1Var);
            f<o1> fVar = this.f4381c;
            if (fVar != null) {
                fVar.c(viewHolder.itemView, o1Var, i2, i2);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, viewGroup, i2)) == null) {
            View inflate = this.f4379a.getPageActivity().getLayoutInflater().inflate(R.layout.recommend_forum_horizontal_item_view, (ViewGroup) null);
            if (i2 == 2) {
                return new a(this, inflate);
            }
            return new b(this, inflate);
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }
}
