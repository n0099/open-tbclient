package c.a.s0.e3;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.e3.b;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class e extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f17168e;

    /* renamed from: f  reason: collision with root package name */
    public final List<b.a> f17169f;

    /* renamed from: g  reason: collision with root package name */
    public int f17170g;

    /* renamed from: h  reason: collision with root package name */
    public String f17171h;

    /* renamed from: i  reason: collision with root package name */
    public String f17172i;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a f17173e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f17174f;

        public a(e eVar, b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17174f = eVar;
            this.f17173e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f17174f.f17168e == null) {
                return;
            }
            this.f17174f.g(this.f17173e);
            if (this.f17173e.f17142g == 1) {
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(this.f17174f.f17168e.getPageActivity()).createSubPbActivityConfig(this.f17173e.f17141f + "", this.f17173e.a + "", "search_post", true);
                createSubPbActivityConfig.setKeyPageStartFrom(8);
                this.f17174f.f17168e.sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
                return;
            }
            PbActivityConfig createNormalCfg = new PbActivityConfig(this.f17174f.f17168e.getPageActivity()).createNormalCfg(this.f17173e.f17141f + "", this.f17173e.a + "", "search_post");
            createNormalCfg.setStartFrom(8);
            createNormalCfg.setSortType(0);
            this.f17174f.f17168e.sendMessage(new CustomMessage(2004001, createNormalCfg));
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f17175b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f17176c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f17177d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f17178e;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-769184597, "Lc/a/s0/e3/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-769184597, "Lc/a/s0/e3/e;");
                return;
            }
        }
        TbadkCoreApplication.getInst().getListItemRule().c();
    }

    public e(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f17170g = -1;
        this.f17168e = tbPageContext;
        this.f17169f = new ArrayList();
    }

    public void c(List<b.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.f17169f.clear();
            this.f17169f.addAll(list);
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f17172i = str;
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f17171h = str;
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f17170g = i2;
        }
    }

    public final void g(b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            StatisticItem param = new StatisticItem("c12405").param("fname", aVar.f17140e).param("uid", TbadkCoreApplication.getCurrentAccount());
            int i2 = this.f17170g;
            if (i2 > 0) {
                param.param("tab_id", i2);
            }
            if (aVar != null) {
                if (aVar.f17142g != 1 && aVar.f17143h != 1) {
                    param.param("tid", aVar.f17141f);
                } else {
                    param.param("pid", aVar.a);
                }
                param.param("fid", this.f17172i);
                param.param("query", this.f17171h);
            }
            TiebaStatic.log(param);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            List<b.a> list = this.f17169f;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            List<b.a> list = this.f17169f;
            if (list == null || list.isEmpty() || i2 < 0 || i2 >= this.f17169f.size()) {
                return null;
            }
            return this.f17169f.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(this.f17168e.getPageActivity()).inflate(R.layout.post_search_list_item, (ViewGroup) null);
                b bVar = new b(null);
                bVar.a = (TextView) view.findViewById(R.id.title_text);
                bVar.f17175b = (TextView) view.findViewById(R.id.content_text);
                bVar.f17176c = (TextView) view.findViewById(R.id.label_text);
                bVar.f17177d = (TextView) view.findViewById(R.id.user_name);
                bVar.f17178e = (TextView) view.findViewById(R.id.time_text);
                view.setTag(bVar);
            }
            b bVar2 = (b) view.getTag();
            b.a aVar = this.f17169f.get(i2);
            if (aVar == null) {
                return view;
            }
            String str = TbadkCoreApplication.getInst().getSkinType() == 1 ? "#99260f" : "#e53917";
            bVar2.a.setText(Html.fromHtml(StringHelper.getHighLightString(aVar.f17137b, str)));
            bVar2.f17175b.setText(Html.fromHtml(StringHelper.getHighLightString(aVar.f17139d, str)));
            bVar2.f17177d.setText(aVar.f17144i);
            bVar2.f17178e.setText(StringHelper.getFormatTime(aVar.f17138c));
            bVar2.f17176c.setVisibility(0);
            if (aVar.f17142g == 1) {
                bVar2.f17176c.setText(R.string.floor_text);
            } else if (aVar.f17143h == 1) {
                bVar2.f17176c.setText(R.string.reply_post);
            } else {
                bVar2.f17176c.setVisibility(8);
            }
            view.setOnClickListener(new a(this, aVar));
            SkinManager.setBackgroundColor(view, R.color.CAM_X0201);
            c.a.r0.w0.a.a(this.f17168e, view);
            h(aVar);
            return view;
        }
        return (View) invokeILL.objValue;
    }

    public final void h(b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            StatisticItem param = new StatisticItem("c14171").param("fname", aVar.f17140e).param("uid", TbadkCoreApplication.getCurrentAccount());
            int i2 = this.f17170g;
            if (i2 > 0) {
                param.param("tab_id", i2);
            }
            if (aVar != null) {
                if (aVar.f17142g != 1 && aVar.f17143h != 1) {
                    param.param("tid", aVar.f17141f);
                } else {
                    param.param("pid", aVar.a);
                }
                param.param("fid", this.f17172i);
                param.param("query", this.f17171h);
            }
            TiebaStatic.log(param);
        }
    }
}
