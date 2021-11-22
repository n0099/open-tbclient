package com.baidu.card.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import b.a.e.f.p.l;
import b.a.q0.n.f;
import b.a.q0.s.q.o;
import b.a.q0.s.q.q1;
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
/* loaded from: classes7.dex */
public class HorizontalRecommendForumAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_BAR_ENTRANCE = 2;
    public static final int TYPE_RECOMMEND_FORUM = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f37466a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<b.a.q0.k0.b.a> f37467b;

    /* renamed from: c  reason: collision with root package name */
    public f<q1> f37468c;

    /* loaded from: classes7.dex */
    public class a extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f37469a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f37470b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f37471c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f37472d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f37473e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HorizontalRecommendForumAdapter f37474f;

        /* renamed from: com.baidu.card.adapter.HorizontalRecommendForumAdapter$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class View$OnClickListenerC1635a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f37475e;

            public View$OnClickListenerC1635a(a aVar, HorizontalRecommendForumAdapter horizontalRecommendForumAdapter) {
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
                this.f37475e = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f37475e.f37474f.f37468c == null) {
                    return;
                }
                int adapterPosition = this.f37475e.getAdapterPosition();
                this.f37475e.f37474f.f37468c.a(view, null, adapterPosition, adapterPosition);
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
            this.f37474f = horizontalRecommendForumAdapter;
            this.f37469a = view;
            TbadkCoreApplication.getInst().getString(R.string.attention);
            this.f37470b = (BarImageView) this.f37469a.findViewById(R.id.forum_icon);
            this.f37471c = (ImageView) this.f37469a.findViewById(R.id.square_icon);
            this.f37472d = (TextView) this.f37469a.findViewById(R.id.forum_name);
            this.f37473e = (TextView) this.f37469a.findViewById(R.id.desc);
            this.f37469a.setOnClickListener(new View$OnClickListenerC1635a(this, horizontalRecommendForumAdapter));
        }

        public void a(o oVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, oVar) == null) || oVar == null) {
                return;
            }
            this.f37471c.setVisibility(0);
            this.f37470b.setVisibility(8);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f37471c, R.drawable.ic_icon_pure_square28, null);
            this.f37472d.setText(R.string.forum_square_title);
            this.f37473e.setText(R.string.forum_square_desc_1);
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SkinManager.setViewTextColor(this.f37472d, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f37473e, R.color.CAM_X0109);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f37476a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f37477b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f37478c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f37479d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f37480e;

        /* renamed from: f  reason: collision with root package name */
        public q1 f37481f;

        /* renamed from: g  reason: collision with root package name */
        public String f37482g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ HorizontalRecommendForumAdapter f37483h;

        /* loaded from: classes7.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f37484e;

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
                this.f37484e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f37484e.f37483h.f37468c == null) {
                    return;
                }
                int adapterPosition = this.f37484e.getAdapterPosition();
                this.f37484e.f37483h.f37468c.a(view, this.f37484e.f37481f, adapterPosition, adapterPosition);
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
            this.f37483h = horizontalRecommendForumAdapter;
            this.f37476a = view;
            this.f37482g = TbadkCoreApplication.getInst().getString(R.string.attention);
            this.f37477b = (BarImageView) this.f37476a.findViewById(R.id.forum_icon);
            this.f37478c = (ImageView) this.f37476a.findViewById(R.id.square_icon);
            this.f37479d = (TextView) this.f37476a.findViewById(R.id.forum_name);
            this.f37480e = (TextView) this.f37476a.findViewById(R.id.desc);
            this.f37476a.setOnClickListener(new a(this, horizontalRecommendForumAdapter));
        }

        public void b(q1 q1Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, q1Var) == null) || q1Var == null) {
                return;
            }
            this.f37481f = q1Var;
            this.f37477b.setShowOval(true);
            this.f37477b.setShowOuterBorder(false);
            this.f37477b.setShowInnerBorder(true);
            this.f37477b.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.f37477b.setStrokeColorResId(R.color.CAM_X0401);
            this.f37478c.setVisibility(8);
            this.f37477b.setVisibility(0);
            this.f37477b.startLoad(q1Var.k(), 10, false);
            if (StringHelper.getChineseAndEnglishLength(q1Var.p()) <= 10) {
                this.f37479d.setText(q1Var.p());
            } else {
                this.f37479d.setText(StringHelper.cutChineseAndEnglishWithSuffix(q1Var.p(), 8, "..."));
            }
            this.f37480e.setText(this.f37482g + " " + StringHelper.numFormatOverWanWithoutDecimals(q1Var.q()));
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SkinManager.setViewTextColor(this.f37479d, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f37480e, R.color.CAM_X0109);
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
        this.f37467b = new ArrayList<>();
        this.f37466a = tbPageContext;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList<b.a.q0.k0.b.a> arrayList = this.f37467b;
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
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (this.f37467b.get(i2) instanceof q1) {
                return 1;
            }
            return this.f37467b.get(i2) instanceof o ? 2 : 0;
        }
        return invokeI.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        ArrayList<b.a.q0.k0.b.a> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewHolder, i2) == null) || (arrayList = this.f37467b) == null || arrayList.size() <= 0) {
            return;
        }
        b.a.q0.k0.b.a aVar = this.f37467b.get(i2);
        if ((viewHolder instanceof a) && (aVar instanceof o)) {
            ((a) viewHolder).a((o) aVar);
        } else if ((viewHolder instanceof b) && (aVar instanceof q1)) {
            q1 q1Var = (q1) aVar;
            ((b) viewHolder).b(q1Var);
            f<q1> fVar = this.f37468c;
            if (fVar != null) {
                fVar.c(viewHolder.itemView, q1Var, i2, i2);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, viewGroup, i2)) == null) {
            View inflate = this.f37466a.getPageActivity().getLayoutInflater().inflate(R.layout.recommend_forum_horizontal_item_view, (ViewGroup) null);
            if (i2 == 2) {
                return new a(this, inflate);
            }
            return new b(this, inflate);
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }

    public void setData(ArrayList<? extends b.a.q0.k0.b.a> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, arrayList) == null) || arrayList == null) {
            return;
        }
        this.f37467b.clear();
        this.f37467b.addAll(arrayList);
        notifyDataSetChanged();
    }

    public void setHasLikeForum(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
        }
    }

    public void setOnItemCoverListener(f<q1> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) {
            this.f37468c = fVar;
        }
    }

    public void setTabName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
        }
    }
}
