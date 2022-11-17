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
import com.baidu.tieba.hu4;
import com.baidu.tieba.is4;
import com.baidu.tieba.kq4;
import com.baidu.tieba.vc5;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class HorizontalRecommendForumAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public ArrayList<vc5> b;
    public kq4<hu4> c;

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
        }
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
        }
    }

    /* loaded from: classes.dex */
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
        /* loaded from: classes.dex */
        public class View$OnClickListenerC0084a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public View$OnClickListenerC0084a(a aVar, HorizontalRecommendForumAdapter horizontalRecommendForumAdapter) {
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
                    this.a.f.c.c(view2, null, adapterPosition, adapterPosition);
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
            TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02b1);
            this.b = (BarImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090a96);
            this.c = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f091fab);
            this.d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090aac);
            this.e = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0907af);
            this.a.setOnClickListener(new View$OnClickListenerC0084a(this, horizontalRecommendForumAdapter));
        }

        public void a(is4 is4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, is4Var) != null) || is4Var == null) {
                return;
            }
            this.c.setVisibility(0);
            this.b.setVisibility(8);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.c, R.drawable.obfuscated_res_0x7f08061f, null);
            this.d.setText(R.string.obfuscated_res_0x7f0f06e3);
            this.e.setText(R.string.obfuscated_res_0x7f0f06e0);
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

    /* loaded from: classes.dex */
    public class b extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public BarImageView b;
        public ImageView c;
        public TextView d;
        public TextView e;
        public hu4 f;
        public String g;
        public final /* synthetic */ HorizontalRecommendForumAdapter h;

        /* loaded from: classes.dex */
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
                    this.a.h.c.c(view2, this.a.f, adapterPosition, adapterPosition);
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
            this.g = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02b1);
            this.b = (BarImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090a96);
            this.c = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f091fab);
            this.d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090aac);
            this.e = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0907af);
            this.a.setOnClickListener(new a(this, horizontalRecommendForumAdapter));
        }

        public void b(hu4 hu4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, hu4Var) != null) || hu4Var == null) {
                return;
            }
            this.f = hu4Var;
            this.b.setShowOval(true);
            this.b.setShowOuterBorder(false);
            this.b.setShowInnerBorder(true);
            this.b.setStrokeWith(yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.b.setStrokeColorResId(R.color.CAM_X0401);
            this.c.setVisibility(8);
            this.b.setVisibility(0);
            this.b.K(hu4Var.h(), 10, false);
            if (StringHelper.getChineseAndEnglishLength(hu4Var.l()) <= 10) {
                this.d.setText(hu4Var.l());
            } else {
                this.d.setText(StringHelper.cutChineseAndEnglishWithSuffix(hu4Var.l(), 8, StringHelper.STRING_MORE));
            }
            this.e.setText(this.g + " " + StringHelper.numFormatOverWanWithoutDecimals(hu4Var.n()));
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
            View inflate = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0789, (ViewGroup) null);
            if (i == 2) {
                return new a(this, inflate);
            }
            return new b(this, inflate);
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }

    public void e(ArrayList<? extends vc5> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, arrayList) != null) || arrayList == null) {
            return;
        }
        this.b.clear();
        this.b.addAll(arrayList);
        notifyDataSetChanged();
    }

    public void g(kq4<hu4> kq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, kq4Var) == null) {
            this.c = kq4Var;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            if (this.b.get(i) instanceof hu4) {
                return 1;
            }
            if (this.b.get(i) instanceof is4) {
                return 2;
            }
            return 0;
        }
        return invokeI.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList<vc5> arrayList = this.b;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ArrayList<vc5> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048582, this, viewHolder, i) == null) && (arrayList = this.b) != null && arrayList.size() > 0) {
            vc5 vc5Var = this.b.get(i);
            if ((viewHolder instanceof a) && (vc5Var instanceof is4)) {
                ((a) viewHolder).a((is4) vc5Var);
            } else if ((viewHolder instanceof b) && (vc5Var instanceof hu4)) {
                hu4 hu4Var = (hu4) vc5Var;
                ((b) viewHolder).b(hu4Var);
                kq4<hu4> kq4Var = this.c;
                if (kq4Var != null) {
                    kq4Var.d(viewHolder.itemView, hu4Var, i, i);
                }
            }
        }
    }
}
