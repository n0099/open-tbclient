package c.a.p0.e1.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.p0.e1.b.e;
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
/* loaded from: classes2.dex */
public class b extends c.a.p0.h0.b<c.a.p0.e1.c.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WrapLineLayout i;
    public List<a> j;
    public int k;

    /* loaded from: classes2.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f13795b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f13796c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b f13797d;

        /* renamed from: c.a.p0.e1.d.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class View$OnLongClickListenerC1039a implements View.OnLongClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public View$OnLongClickListenerC1039a(a aVar, b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, bVar};
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

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                    for (a aVar : this.a.f13797d.j) {
                        if (aVar != null && aVar.b() != view) {
                            aVar.d(false);
                        }
                    }
                    this.a.d(true);
                    return true;
                }
                return invokeL.booleanValue;
            }
        }

        /* renamed from: c.a.p0.e1.d.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class View$OnClickListenerC1040b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public View$OnClickListenerC1040b(a aVar, b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, bVar};
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
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.f13795b.getText() == null || StringUtils.isNull(this.a.f13795b.getText().toString())) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921021, this.a.f13795b.getText().toString()));
            }
        }

        /* loaded from: classes2.dex */
        public class c implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public c(a aVar, b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, bVar};
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
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.f13795b.getText() == null) {
                    return;
                }
                e.b(this.a.f13795b.getText().toString());
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13797d = bVar;
            View inflate = LayoutInflater.from(bVar.j().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d02cd, (ViewGroup) null);
            this.a = inflate;
            this.f13795b = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0906d7);
            this.f13796c = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09076d);
            c();
            this.f13795b.setOnLongClickListener(new View$OnLongClickListenerC1039a(this, bVar));
            this.f13795b.setOnClickListener(new View$OnClickListenerC1040b(this, bVar));
            this.f13796c.setOnClickListener(new c(this, bVar));
        }

        public View b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (View) invokeV.objValue;
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SkinManager.setViewTextColor(this.f13795b, (int) R.color.CAM_X0105);
                SkinManager.setBackgroundResource(this.f13795b, R.drawable.search_history_item_bg);
                SkinManager.setImageResource(this.f13796c, R.drawable.del_search_btn);
            }
        }

        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                if (z) {
                    this.f13796c.setVisibility(0);
                    SkinManager.setImageResource(this.f13796c, R.drawable.del_search_btn);
                    return;
                }
                this.f13796c.setVisibility(4);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new ArrayList();
        this.k = 3;
        this.i = (WrapLineLayout) k();
    }

    @Override // c.a.p0.h0.b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d02cc : invokeV.intValue;
    }

    @Override // c.a.p0.h0.b
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) || this.k == i) {
            return;
        }
        for (a aVar : this.j) {
            if (aVar != null) {
                aVar.c();
            }
        }
        this.k = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
        }
    }

    public final a s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new a(this) : (a) invokeV.objValue;
    }

    public final void t(int i) {
        int size;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || (size = this.j.size()) == i) {
            return;
        }
        int i2 = 0;
        if (size < i) {
            int i3 = i - size;
            while (i2 < i3) {
                a s = s();
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
                int f2 = n.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0701d4);
                marginLayoutParams.topMargin = f2;
                marginLayoutParams.leftMargin = f2;
                this.i.addView(s.b(), marginLayoutParams);
                this.j.add(s);
                i2++;
            }
        } else if (i == 0) {
            this.i.removeAllViews();
            this.j.clear();
        } else if (size > i) {
            int i4 = size - i;
            while (i2 < i4) {
                this.i.removeView(this.j.get(i2).b());
                this.j.remove(i2);
                i2++;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.h0.b
    /* renamed from: u */
    public void l(c.a.p0.e1.c.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) || aVar == null || ListUtils.isEmpty(aVar.e())) {
            return;
        }
        t(aVar.e().size());
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            a aVar2 = this.j.get(i);
            if (aVar2 != null) {
                aVar2.d(false);
                aVar2.f13795b.setText(aVar.e().get(i));
            }
        }
        m(this.f15304b, TbadkCoreApplication.getInst().getSkinType());
    }
}
