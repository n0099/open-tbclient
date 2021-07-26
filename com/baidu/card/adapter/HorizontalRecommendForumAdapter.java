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
import d.a.d.e.p.l;
import d.a.p0.n.f;
import d.a.p0.s.q.o;
import d.a.p0.s.q.o1;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class HorizontalRecommendForumAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f4405a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<d.a.p0.i0.b.a> f4406b;

    /* renamed from: c  reason: collision with root package name */
    public f<o1> f4407c;

    /* loaded from: classes.dex */
    public class a extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f4408a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f4409b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f4410c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f4411d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f4412e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HorizontalRecommendForumAdapter f4413f;

        /* renamed from: com.baidu.card.adapter.HorizontalRecommendForumAdapter$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class View$OnClickListenerC0084a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f4414e;

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
                this.f4414e = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f4414e.f4413f.f4407c == null) {
                    return;
                }
                int adapterPosition = this.f4414e.getAdapterPosition();
                this.f4414e.f4413f.f4407c.a(view, null, adapterPosition, adapterPosition);
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
            this.f4413f = horizontalRecommendForumAdapter;
            this.f4408a = view;
            TbadkCoreApplication.getInst().getString(R.string.attention);
            this.f4409b = (BarImageView) this.f4408a.findViewById(R.id.forum_icon);
            this.f4410c = (ImageView) this.f4408a.findViewById(R.id.square_icon);
            this.f4411d = (TextView) this.f4408a.findViewById(R.id.forum_name);
            this.f4412e = (TextView) this.f4408a.findViewById(R.id.desc);
            this.f4408a.setOnClickListener(new View$OnClickListenerC0084a(this, horizontalRecommendForumAdapter));
        }

        public void a(o oVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, oVar) == null) || oVar == null) {
                return;
            }
            this.f4410c.setVisibility(0);
            this.f4409b.setVisibility(8);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f4410c, R.drawable.ic_icon_pure_square28, null);
            this.f4411d.setText(R.string.forum_square_title);
            this.f4412e.setText(R.string.forum_square_desc_1);
            b();
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SkinManager.setViewTextColor(this.f4411d, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f4412e, R.color.CAM_X0109);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f4415a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f4416b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f4417c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f4418d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f4419e;

        /* renamed from: f  reason: collision with root package name */
        public o1 f4420f;

        /* renamed from: g  reason: collision with root package name */
        public String f4421g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ HorizontalRecommendForumAdapter f4422h;

        /* loaded from: classes.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f4423e;

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
                this.f4423e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f4423e.f4422h.f4407c == null) {
                    return;
                }
                int adapterPosition = this.f4423e.getAdapterPosition();
                this.f4423e.f4422h.f4407c.a(view, this.f4423e.f4420f, adapterPosition, adapterPosition);
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
            this.f4422h = horizontalRecommendForumAdapter;
            this.f4415a = view;
            this.f4421g = TbadkCoreApplication.getInst().getString(R.string.attention);
            this.f4416b = (BarImageView) this.f4415a.findViewById(R.id.forum_icon);
            this.f4417c = (ImageView) this.f4415a.findViewById(R.id.square_icon);
            this.f4418d = (TextView) this.f4415a.findViewById(R.id.forum_name);
            this.f4419e = (TextView) this.f4415a.findViewById(R.id.desc);
            this.f4415a.setOnClickListener(new a(this, horizontalRecommendForumAdapter));
        }

        public void b(o1 o1Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, o1Var) == null) || o1Var == null) {
                return;
            }
            this.f4420f = o1Var;
            this.f4416b.setShowOval(true);
            this.f4416b.setShowOuterBorder(false);
            this.f4416b.setShowInnerBorder(true);
            this.f4416b.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.f4416b.setStrokeColorResId(R.color.CAM_X0401);
            this.f4417c.setVisibility(8);
            this.f4416b.setVisibility(0);
            this.f4416b.M(o1Var.e(), 10, false);
            if (StringHelper.getChineseAndEnglishLength(o1Var.j()) <= 10) {
                this.f4418d.setText(o1Var.j());
            } else {
                this.f4418d.setText(StringHelper.cutChineseAndEnglishWithSuffix(o1Var.j(), 8, StringHelper.STRING_MORE));
            }
            this.f4419e.setText(this.f4421g + " " + StringHelper.numFormatOverWanWithoutDecimals(o1Var.o()));
            c();
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SkinManager.setViewTextColor(this.f4418d, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f4419e, R.color.CAM_X0109);
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
        this.f4406b = new ArrayList<>();
        this.f4405a = tbPageContext;
    }

    public void e(ArrayList<? extends d.a.p0.i0.b.a> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, arrayList) == null) || arrayList == null) {
            return;
        }
        this.f4406b.clear();
        this.f4406b.addAll(arrayList);
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
            this.f4407c = fVar;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList<d.a.p0.i0.b.a> arrayList = this.f4406b;
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
            if (this.f4406b.get(i2) instanceof o1) {
                return 1;
            }
            return this.f4406b.get(i2) instanceof o ? 2 : 0;
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
        ArrayList<d.a.p0.i0.b.a> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, viewHolder, i2) == null) || (arrayList = this.f4406b) == null || arrayList.size() <= 0) {
            return;
        }
        d.a.p0.i0.b.a aVar = this.f4406b.get(i2);
        if ((viewHolder instanceof a) && (aVar instanceof o)) {
            ((a) viewHolder).a((o) aVar);
        } else if ((viewHolder instanceof b) && (aVar instanceof o1)) {
            o1 o1Var = (o1) aVar;
            ((b) viewHolder).b(o1Var);
            f<o1> fVar = this.f4407c;
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
            View inflate = this.f4405a.getPageActivity().getLayoutInflater().inflate(R.layout.recommend_forum_horizontal_item_view, (ViewGroup) null);
            if (i2 == 2) {
                return new a(this, inflate);
            }
            return new b(this, inflate);
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }
}
