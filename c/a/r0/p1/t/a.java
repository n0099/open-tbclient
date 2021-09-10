package c.a.r0.p1.t;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a extends c.a.q0.s.f0.u.b<c.a.q0.s.f0.u.d.a, C1106a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public Context f23704d;

    /* renamed from: c.a.r0.p1.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1106a extends BdBaseViewPagerAdapter.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public TbImageView f23705h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1106a(a aVar, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, view};
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
            if (view instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) view;
                this.f23705h = tbImageView;
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId};
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
        this.f23704d = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.q0.s.f0.u.b
    /* renamed from: h */
    public C1106a c(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            TbImageView tbImageView = new TbImageView(this.f23704d);
            tbImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            return new C1106a(this, tbImageView);
        }
        return (C1106a) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.q0.s.f0.u.b
    /* renamed from: i */
    public View e(ViewGroup viewGroup, C1106a c1106a, c.a.q0.s.f0.u.d.a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, viewGroup, c1106a, aVar)) == null) {
            c1106a.f23705h.startLoad(aVar.b(), 17, false);
            return null;
        }
        return (View) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.q0.s.f0.u.b
    /* renamed from: j */
    public void f(int i2, C1106a c1106a, c.a.q0.s.f0.u.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048581, this, i2, c1106a, aVar) == null) {
        }
    }
}
