package b.a.r0.w.f.b.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.ala.atomdata.AlaNewSquareSubListActivityConfig;
import com.baidu.ala.square.IAlaSquareTabController;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.holder.SquareLiveCategoryViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends b.a.e.m.e.a<b.a.r0.w.f.b.b.b, SquareLiveCategoryViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IAlaSquareTabController m;

    /* renamed from: b.a.r0.w.f.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1265a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.w.f.b.b.b f26036e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f26037f;

        public View$OnClickListenerC1265a(a aVar, b.a.r0.w.f.b.b.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26037f = aVar;
            this.f26036e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f26037f.m != null) {
                    int tabIndex = this.f26037f.m.getTabIndex(this.f26036e.f26051e);
                    if (tabIndex >= 0) {
                        this.f26037f.m.goToTab(tabIndex);
                        return;
                    } else {
                        this.f26037f.i0(this.f26036e);
                        return;
                    }
                }
                this.f26037f.i0(this.f26036e);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void i0(b.a.r0.w.f.b.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            Context context = this.f2421e;
            String str = bVar.f26054h;
            String str2 = bVar.f26052f;
            String str3 = bVar.f26053g;
            List<String> list = bVar.f26055i;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaNewSquareSubListActivityConfig(context, str, str2, str3, (list == null || !(list instanceof ArrayList)) ? null : (ArrayList) list)));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: j0 */
    public SquareLiveCategoryViewHolder T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) ? new SquareLiveCategoryViewHolder(LayoutInflater.from(this.f2421e).inflate(R.layout.square_live_category_layout, viewGroup, false)) : (SquareLiveCategoryViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: k0 */
    public View Z(int i2, View view, ViewGroup viewGroup, b.a.r0.w.f.b.b.b bVar, SquareLiveCategoryViewHolder squareLiveCategoryViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, bVar, squareLiveCategoryViewHolder})) == null) {
            View findViewById = squareLiveCategoryViewHolder.mView.findViewById(R.id.live_category_top_line);
            TextView textView = (TextView) squareLiveCategoryViewHolder.mView.findViewById(R.id.live_category_entry_name);
            TextView textView2 = (TextView) squareLiveCategoryViewHolder.mView.findViewById(R.id.live_category_entry_tv);
            ImageView imageView = (ImageView) squareLiveCategoryViewHolder.mView.findViewById(R.id.live_category_entry_img);
            if (i2 == 0) {
                findViewById.setVisibility(8);
            } else {
                findViewById.setVisibility(0);
            }
            SkinManager.setBackgroundColor(findViewById, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(squareLiveCategoryViewHolder.mView, R.color.CAM_X0201);
            SkinManager.setViewTextColor(textView, R.color.CAM_X0106);
            SkinManager.setViewTextColor(textView2, R.color.CAM_X0109);
            SkinManager.setImageResource(imageView, R.drawable.icon_arrow_tab);
            textView.setText(!TextUtils.isEmpty(bVar.f26053g) ? bVar.f26053g : bVar.f26052f);
            textView2.setOnClickListener(new View$OnClickListenerC1265a(this, bVar));
            return squareLiveCategoryViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void l0(IAlaSquareTabController iAlaSquareTabController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, iAlaSquareTabController) == null) {
            this.m = iAlaSquareTabController;
        }
    }
}
