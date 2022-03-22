package c.a.p0.b3.k;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import c.a.o0.c1.o0;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b extends c.a.p0.h0.b<c.a.p0.b3.e.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public BarImageView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public c.a.p0.b3.e.b r;
    public LikeModel s;
    public boolean t;
    public CustomMessageListener u;
    public CustomMessageListener v;

    /* loaded from: classes2.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.t) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof c.a.p0.a4.t0.f) {
                c.a.p0.a4.t0.f fVar = (c.a.p0.a4.t0.f) data;
                if (fVar.a == this.a.r.f12700f) {
                    if (fVar.f12402b) {
                        this.a.r.i = true;
                        this.a.q.setVisibility(0);
                        this.a.y(true);
                        c.a.d.f.p.n.M(this.a.f15305c, R.string.obfuscated_res_0x7f0f02ab);
                    } else if (StringUtils.isNull(fVar.f12403c)) {
                        c.a.d.f.p.n.M(this.a.f15305c, R.string.obfuscated_res_0x7f0f02a5);
                    } else {
                        c.a.d.f.p.n.N(this.a.f15305c, fVar.f12403c);
                    }
                }
            }
        }
    }

    /* renamed from: c.a.p0.b3.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0966b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0966b(b bVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.t) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof c.a.p0.a4.t0.f) {
                c.a.p0.a4.t0.f fVar = (c.a.p0.a4.t0.f) data;
                if (fVar.a == this.a.r.f12700f) {
                    if (fVar.f12402b) {
                        this.a.r.i = false;
                        this.a.q.setVisibility(0);
                        b bVar = this.a;
                        bVar.y(bVar.r.i);
                        c.a.d.f.p.n.M(this.a.f15305c, R.string.obfuscated_res_0x7f0f1480);
                        return;
                    }
                    c.a.d.f.p.n.M(this.a.f15305c, R.string.obfuscated_res_0x7f0f147f);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext tbPageContext) {
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
        this.u = new a(this, 2001437);
        this.v = new C0966b(this, 2001438);
        v(k());
    }

    @Override // c.a.p0.h0.b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d01b5 : invokeV.intValue;
    }

    @Override // c.a.p0.h0.b
    public void m(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            if (this.a != i) {
                SkinManager.setBackgroundResource(this.i, R.drawable.item_person_header_attention_bg_selector);
                SkinManager.setViewTextColor(this.j, R.color.CAM_X0106, 1);
                SkinManager.setViewTextColor(this.k, R.color.CAM_X0106, 1);
                SkinManager.setViewTextColor(this.l, R.color.CAM_X0106, 1);
                SkinManager.setViewTextColor(this.m, R.color.CAM_X0106, 1);
                SkinManager.setViewTextColor(this.o, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(this.p, R.color.CAM_X0108, 1);
                c.a.p0.b3.e.b bVar = this.r;
                if (bVar != null) {
                    y(bVar.i);
                }
            }
            this.a = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if (this.i == view) {
                if (!this.t) {
                    TiebaStatic.log(new StatisticItem("c11595"));
                }
                this.f15304b.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f15305c).createNormalCfg(this.r.f12702h, "")));
            } else if (this.q == view) {
                TiebaStatic.log(new StatisticItem("c11596"));
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ViewHelper.skipToLoginActivity(this.f15305c);
                } else if (c.a.d.f.p.m.isForumName(this.r.f12702h)) {
                    c.a.p0.b3.e.b bVar = this.r;
                    if (bVar.i) {
                        return;
                    }
                    this.s.P(bVar.f12702h, String.valueOf(bVar.f12700f));
                }
            }
        }
    }

    public final void v(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            this.i = view.findViewById(R.id.obfuscated_res_0x7f090569);
            this.j = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090565);
            this.k = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090567);
            this.l = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09056d);
            this.m = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090566);
            this.n = (BarImageView) view.findViewById(R.id.obfuscated_res_0x7f09056b);
            this.o = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090568);
            this.p = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09056c);
            this.q = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09056a);
            this.i.setOnClickListener(this);
            this.q.setOnClickListener(this);
            this.f15304b.registerListener(this.u);
            this.f15304b.registerListener(this.v);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.h0.b
    /* renamed from: w */
    public void l(c.a.p0.b3.e.b bVar) {
        Context context;
        int i;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            if (bVar == null) {
                this.i.setVisibility(8);
                return;
            }
            if (this.i.getVisibility() != 0) {
                this.i.setVisibility(0);
            }
            this.r = bVar;
            this.t = bVar.a;
            this.j.setVisibility(bVar.f12697c ? 0 : 4);
            this.k.setVisibility(bVar.f12697c ? 0 : 4);
            this.j.setText(bVar.f12699e);
            this.k.setText(bVar.f12698d);
            TextView textView = this.l;
            if (bVar.a) {
                string = this.f15305c.getString(R.string.obfuscated_res_0x7f0f0a97);
            } else {
                if (bVar.f12696b == 2) {
                    context = this.f15305c;
                    i = R.string.obfuscated_res_0x7f0f1150;
                } else {
                    context = this.f15305c;
                    i = R.string.obfuscated_res_0x7f0f0818;
                }
                string = context.getString(i);
            }
            textView.setText(string);
            this.n.J(bVar.f12701g, 10, false);
            String str = bVar.f12702h;
            if (o0.b(str) > 10) {
                str = o0.k(str, 0, 10) + StringHelper.STRING_MORE;
            }
            this.o.setText(String.format(this.f15305c.getString(R.string.obfuscated_res_0x7f0f0e25), str));
            String numFormatOverWanNa = StringHelper.numFormatOverWanNa(bVar.j);
            this.p.setText(bVar.a ? String.format(this.f15305c.getString(R.string.obfuscated_res_0x7f0f0e24), numFormatOverWanNa, StringHelper.numFormatOverWanNa(bVar.k)) : String.format(this.f15305c.getString(R.string.obfuscated_res_0x7f0f0e23), numFormatOverWanNa));
            if (!bVar.i && !bVar.a) {
                this.q.setVisibility(0);
                y(bVar.i);
                return;
            }
            this.q.setVisibility(8);
        }
    }

    public void x(LikeModel likeModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, likeModel) == null) {
            this.s = likeModel;
        }
    }

    public final void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (z) {
                this.q.setText(this.f15305c.getString(R.string.obfuscated_res_0x7f0f0f68));
                SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0110);
                SkinManager.setBackgroundResource(this.q, R.color.transparent);
                this.q.setClickable(false);
                return;
            }
            this.q.setText(this.f15305c.getString(R.string.obfuscated_res_0x7f0f061f));
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0302, 1);
            SkinManager.setBackgroundResource(this.q, R.drawable.obfuscated_res_0x7f080f81);
            this.q.setClickable(true);
        }
    }
}
