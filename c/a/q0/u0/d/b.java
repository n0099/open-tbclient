package c.a.q0.u0.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.e.e.p.l;
import c.a.q0.u0.b.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.WrapLineLayout;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends c.a.q0.a0.b<c.a.q0.u0.c.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WrapLineLayout m;
    public List<a> n;
    public int o;

    /* loaded from: classes3.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f24907a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f24908b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f24909c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b f24910d;

        /* renamed from: c.a.q0.u0.d.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class View$OnLongClickListenerC1158a implements View.OnLongClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f24911e;

            public View$OnLongClickListenerC1158a(a aVar, b bVar) {
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
                this.f24911e = aVar;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                    for (a aVar : this.f24911e.f24910d.n) {
                        if (aVar != null && aVar.b() != view) {
                            aVar.d(false);
                        }
                    }
                    this.f24911e.d(true);
                    return true;
                }
                return invokeL.booleanValue;
            }
        }

        /* renamed from: c.a.q0.u0.d.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class View$OnClickListenerC1159b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f24912e;

            public View$OnClickListenerC1159b(a aVar, b bVar) {
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
                this.f24912e = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f24912e.f24908b.getText() == null || StringUtils.isNull(this.f24912e.f24908b.getText().toString())) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921021, this.f24912e.f24908b.getText().toString()));
            }
        }

        /* loaded from: classes3.dex */
        public class c implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f24913e;

            public c(a aVar, b bVar) {
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
                this.f24913e = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f24913e.f24908b.getText() == null) {
                    return;
                }
                e.b(this.f24913e.f24908b.getText().toString());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921020));
            }
        }

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24910d = bVar;
            View inflate = LayoutInflater.from(bVar.i().getPageActivity()).inflate(R.layout.forum_search_history_info_item, (ViewGroup) null);
            this.f24907a = inflate;
            this.f24908b = (TextView) inflate.findViewById(R.id.content);
            this.f24909c = (ImageView) this.f24907a.findViewById(R.id.delete);
            c();
            this.f24908b.setOnLongClickListener(new View$OnLongClickListenerC1158a(this, bVar));
            this.f24908b.setOnClickListener(new View$OnClickListenerC1159b(this, bVar));
            this.f24909c.setOnClickListener(new c(this, bVar));
        }

        public View b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f24907a : (View) invokeV.objValue;
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SkinManager.setViewTextColor(this.f24908b, R.color.CAM_X0105);
                SkinManager.setBackgroundResource(this.f24908b, R.drawable.search_history_item_bg);
                SkinManager.setImageResource(this.f24909c, R.drawable.del_search_btn);
            }
        }

        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                if (z) {
                    this.f24909c.setVisibility(0);
                    SkinManager.setImageResource(this.f24909c, R.drawable.del_search_btn);
                    return;
                }
                this.f24909c.setVisibility(4);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new ArrayList();
        this.o = 3;
        this.m = (WrapLineLayout) j();
    }

    @Override // c.a.q0.a0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.forum_search_history_info : invokeV.intValue;
    }

    @Override // c.a.q0.a0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.o == i2) {
            return;
        }
        for (a aVar : this.n) {
            if (aVar != null) {
                aVar.c();
            }
        }
        this.o = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
        }
    }

    public final a q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new a(this) : (a) invokeV.objValue;
    }

    public final void s(int i2) {
        int size;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (size = this.n.size()) == i2) {
            return;
        }
        int i3 = 0;
        if (size < i2) {
            int i4 = i2 - size;
            while (i3 < i4) {
                a q = q();
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
                int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.ds2);
                marginLayoutParams.topMargin = g2;
                marginLayoutParams.leftMargin = g2;
                this.m.addView(q.b(), marginLayoutParams);
                this.n.add(q);
                i3++;
            }
        } else if (i2 == 0) {
            this.m.removeAllViews();
            this.n.clear();
        } else if (size > i2) {
            int i5 = size - i2;
            while (i3 < i5) {
                this.m.removeView(this.n.get(i3).b());
                this.n.remove(i3);
                i3++;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.q0.a0.b
    /* renamed from: t */
    public void k(c.a.q0.u0.c.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) || aVar == null || ListUtils.isEmpty(aVar.g())) {
            return;
        }
        s(aVar.g().size());
        int size = this.n.size();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar2 = this.n.get(i2);
            if (aVar2 != null) {
                aVar2.d(false);
                aVar2.f24908b.setText(aVar.g().get(i2));
            }
        }
        l(this.f15232f, TbadkCoreApplication.getInst().getSkinType());
    }
}
