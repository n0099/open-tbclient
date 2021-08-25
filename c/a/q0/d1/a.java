package c.a.q0.d1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.e.e.p.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateBarActivityConfig;
import com.baidu.tbadk.core.atomData.CreateForumActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.home.CreateBarGuideActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.UserBfbInfo;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public CreateBarGuideActivity f16673a;

    /* renamed from: b  reason: collision with root package name */
    public View f16674b;

    /* renamed from: c  reason: collision with root package name */
    public View f16675c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f16676d;

    /* renamed from: e  reason: collision with root package name */
    public NoDataView f16677e;

    /* renamed from: f  reason: collision with root package name */
    public NavigationBar f16678f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16679g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16680h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f16681i;

    /* renamed from: j  reason: collision with root package name */
    public LinearLayout f16682j;
    public TbImageView k;
    public UserBfbInfo l;
    public String m;

    /* renamed from: c.a.q0.d1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0801a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16683e;

        public View$OnClickListenerC0801a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16683e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f16683e.l != null) {
                    if (this.f16683e.l.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(this.f16683e.f16673a.getActivity(), this.f16683e.m, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(this.f16683e.f16673a.getActivity(), this.f16683e.m, true)));
                    }
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(this.f16683e.f16673a.getActivity(), this.f16683e.m, true)));
                }
                TiebaStatic.log("c11223");
                this.f16683e.f16673a.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f16684a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16684a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f16684a.l == null) {
                return;
            }
            if (this.f16684a.l.res_no.intValue() == 9528) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(this.f16684a.f16673a.getActivity(), this.f16684a.m, true)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(this.f16684a.f16673a.getActivity(), this.f16684a.m, true)));
            }
        }
    }

    public a(CreateBarGuideActivity createBarGuideActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {createBarGuideActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16673a = createBarGuideActivity;
        View inflate = LayoutInflater.from(createBarGuideActivity.getPageContext().getPageActivity()).inflate(R.layout.create_bar_guide_activity, (ViewGroup) null);
        this.f16674b = inflate;
        this.f16673a.setContentView(inflate);
        this.f16675c = this.f16674b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f16674b.findViewById(R.id.view_navigation_bar);
        this.f16678f = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f16678f.setTitleText(R.string.create_bar);
        this.f16676d = (NoNetworkView) this.f16674b.findViewById(R.id.view_no_network);
        this.f16680h = (TextView) this.f16674b.findViewById(R.id.text_forum_name);
        this.f16679g = (TextView) this.f16674b.findViewById(R.id.text_forum_create);
        this.k = (TbImageView) this.f16674b.findViewById(R.id.status_icon);
        this.f16679g.setOnClickListener(new View$OnClickListenerC0801a(this));
        this.f16681i = (TextView) this.f16674b.findViewById(R.id.text_create_need);
        this.f16682j = (LinearLayout) this.f16674b.findViewById(R.id.need_desc_layout);
        MessageManager.getInstance().registerListener(new b(this, 2016458));
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f16674b : (View) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f16675c.setVisibility(8);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.p0.u0.a.a(this.f16673a.getPageContext(), this.f16674b);
            NavigationBar navigationBar = this.f16678f;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f16673a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
            NoNetworkView noNetworkView = this.f16676d;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(this.f16673a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
            NoDataView noDataView = this.f16677e;
            if (noDataView != null) {
                noDataView.onChangeSkinType(this.f16673a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f16675c.setVisibility(0);
        }
    }

    public void h(String str, UserBfbInfo userBfbInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, userBfbInfo) == null) {
            this.m = str;
            this.l = userBfbInfo;
            if (this.f16677e == null) {
                int g2 = l.g(this.f16673a.getActivity(), R.dimen.ds100);
                NoDataView a2 = NoDataViewFactory.a(this.f16673a.getPageContext().getPageActivity(), (LinearLayout) this.f16674b.findViewById(R.id.emotion_layout), NoDataViewFactory.d.b(NoDataViewFactory.ImgType.CREATE, g2), null, null);
                this.f16677e = a2;
                a2.setVisibility(0);
                f();
            }
            TextView textView = this.f16680h;
            textView.setText(this.m + "吧");
            UserBfbInfo userBfbInfo2 = this.l;
            if (userBfbInfo2 != null && userBfbInfo2.res_no.intValue() == 9528) {
                if (this.l.activity_status.intValue() == 0) {
                    this.k.setImageResource(R.drawable.icon_create_attention_n);
                } else {
                    this.k.setImageResource(R.drawable.icon_create_complete_n);
                }
            } else {
                this.f16681i.setVisibility(4);
                this.f16682j.setVisibility(4);
            }
            this.f16681i.setVisibility(8);
            this.f16682j.setVisibility(8);
        }
    }
}
