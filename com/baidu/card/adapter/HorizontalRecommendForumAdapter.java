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
import com.baidu.tieba.dk5;
import com.baidu.tieba.ii;
import com.baidu.tieba.yw4;
import com.baidu.tieba.yy4;
import com.baidu.tieba.zu4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class HorizontalRecommendForumAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public ArrayList<dk5> b;
    public zu4<yy4> c;

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
        }
    }

    /* loaded from: classes2.dex */
    public class a extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public BarImageView b;
        public ImageView c;
        public TextView d;
        public TextView e;
        public final /* synthetic */ HorizontalRecommendForumAdapter f;

        /* renamed from: com.baidu.card.adapter.HorizontalRecommendForumAdapter$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class View$OnClickListenerC0082a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public View$OnClickListenerC0082a(a aVar, HorizontalRecommendForumAdapter horizontalRecommendForumAdapter) {
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
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.f.c != null) {
                    int adapterPosition = this.a.getAdapterPosition();
                    this.a.f.c.d(view2, null, adapterPosition, adapterPosition);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(HorizontalRecommendForumAdapter horizontalRecommendForumAdapter, View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizontalRecommendForumAdapter, view2};
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
            this.f = horizontalRecommendForumAdapter;
            this.a = view2;
            TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02b9);
            this.b = (BarImageView) this.a.findViewById(R.id.forum_icon);
            this.c = (ImageView) this.a.findViewById(R.id.square_icon);
            this.d = (TextView) this.a.findViewById(R.id.forum_name);
            this.e = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090842);
            this.a.setOnClickListener(new View$OnClickListenerC0082a(this, horizontalRecommendForumAdapter));
        }

        public void a(yw4 yw4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, yw4Var) != null) || yw4Var == null) {
                return;
            }
            this.c.setVisibility(0);
            this.b.setVisibility(8);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.c, R.drawable.ic_icon_pure_square28, null);
            this.d.setText(R.string.forum_square_title);
            this.e.setText(R.string.forum_square_desc_1);
            b();
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0109);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public BarImageView b;
        public ImageView c;
        public TextView d;
        public TextView e;
        public yy4 f;
        public String g;
        public final /* synthetic */ HorizontalRecommendForumAdapter h;

        /* loaded from: classes2.dex */
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
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.h.c != null) {
                    int adapterPosition = this.a.getAdapterPosition();
                    this.a.h.c.d(view2, this.a.f, adapterPosition, adapterPosition);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(HorizontalRecommendForumAdapter horizontalRecommendForumAdapter, View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizontalRecommendForumAdapter, view2};
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
            this.h = horizontalRecommendForumAdapter;
            this.a = view2;
            this.g = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02b9);
            this.b = (BarImageView) this.a.findViewById(R.id.forum_icon);
            this.c = (ImageView) this.a.findViewById(R.id.square_icon);
            this.d = (TextView) this.a.findViewById(R.id.forum_name);
            this.e = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090842);
            this.a.setOnClickListener(new a(this, horizontalRecommendForumAdapter));
        }

        public void b(yy4 yy4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, yy4Var) != null) || yy4Var == null) {
                return;
            }
            this.f = yy4Var;
            this.b.setShowOval(true);
            this.b.setShowOuterBorder(false);
            this.b.setShowInnerBorder(true);
            this.b.setStrokeWith(ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.b.setStrokeColorResId(R.color.CAM_X0401);
            this.c.setVisibility(8);
            this.b.setVisibility(0);
            this.b.N(yy4Var.e(), 10, false);
            if (StringHelper.getChineseAndEnglishLength(yy4Var.h()) <= 10) {
                this.d.setText(yy4Var.h());
            } else {
                this.d.setText(StringHelper.cutChineseAndEnglishWithSuffix(yy4Var.h(), 8, StringHelper.STRING_MORE));
            }
            this.e.setText(this.g + " " + StringHelper.numFormatOverWanWithoutDecimals(yy4Var.i()));
            c();
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0109);
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
        this.b = new ArrayList<>();
        this.a = tbPageContext;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, viewGroup, i)) == null) {
            View inflate = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.recommend_forum_horizontal_item_view, (ViewGroup) null);
            if (i == 2) {
                return new a(this, inflate);
            }
            return new b(this, inflate);
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (this.b.get(i) instanceof yy4) {
                return 1;
            }
            if (this.b.get(i) instanceof yw4) {
                return 2;
            }
            return 0;
        }
        return invokeI.intValue;
    }

    public void l(ArrayList<? extends dk5> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) != null) || arrayList == null) {
            return;
        }
        this.b.clear();
        this.b.addAll(arrayList);
        notifyDataSetChanged();
    }

    public void n(zu4<yy4> zu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, zu4Var) == null) {
            this.c = zu4Var;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList<dk5> arrayList = this.b;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ArrayList<dk5> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048582, this, viewHolder, i) == null) && (arrayList = this.b) != null && arrayList.size() > 0) {
            dk5 dk5Var = this.b.get(i);
            if ((viewHolder instanceof a) && (dk5Var instanceof yw4)) {
                ((a) viewHolder).a((yw4) dk5Var);
            } else if ((viewHolder instanceof b) && (dk5Var instanceof yy4)) {
                yy4 yy4Var = (yy4) dk5Var;
                ((b) viewHolder).b(yy4Var);
                zu4<yy4> zu4Var = this.c;
                if (zu4Var != null) {
                    zu4Var.c(viewHolder.itemView, yy4Var, i, i);
                }
            }
        }
    }
}
