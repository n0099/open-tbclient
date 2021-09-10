package c.a.r0.e1;

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
    public CreateBarGuideActivity f17228a;

    /* renamed from: b  reason: collision with root package name */
    public View f17229b;

    /* renamed from: c  reason: collision with root package name */
    public View f17230c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f17231d;

    /* renamed from: e  reason: collision with root package name */
    public NoDataView f17232e;

    /* renamed from: f  reason: collision with root package name */
    public NavigationBar f17233f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17234g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f17235h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f17236i;

    /* renamed from: j  reason: collision with root package name */
    public LinearLayout f17237j;
    public TbImageView k;
    public UserBfbInfo l;
    public String m;

    /* renamed from: c.a.r0.e1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0834a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f17238e;

        public View$OnClickListenerC0834a(a aVar) {
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
            this.f17238e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f17238e.l != null) {
                    if (this.f17238e.l.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(this.f17238e.f17228a.getActivity(), this.f17238e.m, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(this.f17238e.f17228a.getActivity(), this.f17238e.m, true)));
                    }
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(this.f17238e.f17228a.getActivity(), this.f17238e.m, true)));
                }
                TiebaStatic.log("c11223");
                this.f17238e.f17228a.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f17239a;

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
            this.f17239a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f17239a.l == null) {
                return;
            }
            if (this.f17239a.l.res_no.intValue() == 9528) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(this.f17239a.f17228a.getActivity(), this.f17239a.m, true)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(this.f17239a.f17228a.getActivity(), this.f17239a.m, true)));
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
        this.f17228a = createBarGuideActivity;
        View inflate = LayoutInflater.from(createBarGuideActivity.getPageContext().getPageActivity()).inflate(R.layout.create_bar_guide_activity, (ViewGroup) null);
        this.f17229b = inflate;
        this.f17228a.setContentView(inflate);
        this.f17230c = this.f17229b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f17229b.findViewById(R.id.view_navigation_bar);
        this.f17233f = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f17233f.setTitleText(R.string.create_bar);
        this.f17231d = (NoNetworkView) this.f17229b.findViewById(R.id.view_no_network);
        this.f17235h = (TextView) this.f17229b.findViewById(R.id.text_forum_name);
        this.f17234g = (TextView) this.f17229b.findViewById(R.id.text_forum_create);
        this.k = (TbImageView) this.f17229b.findViewById(R.id.status_icon);
        this.f17234g.setOnClickListener(new View$OnClickListenerC0834a(this));
        this.f17236i = (TextView) this.f17229b.findViewById(R.id.text_create_need);
        this.f17237j = (LinearLayout) this.f17229b.findViewById(R.id.need_desc_layout);
        MessageManager.getInstance().registerListener(new b(this, 2016458));
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f17229b : (View) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f17230c.setVisibility(8);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.q0.w0.a.a(this.f17228a.getPageContext(), this.f17229b);
            NavigationBar navigationBar = this.f17233f;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f17228a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
            NoNetworkView noNetworkView = this.f17231d;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(this.f17228a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
            NoDataView noDataView = this.f17232e;
            if (noDataView != null) {
                noDataView.onChangeSkinType(this.f17228a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f17230c.setVisibility(0);
        }
    }

    public void h(String str, UserBfbInfo userBfbInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, userBfbInfo) == null) {
            this.m = str;
            this.l = userBfbInfo;
            if (this.f17232e == null) {
                int g2 = l.g(this.f17228a.getActivity(), R.dimen.ds100);
                NoDataView a2 = NoDataViewFactory.a(this.f17228a.getPageContext().getPageActivity(), (LinearLayout) this.f17229b.findViewById(R.id.emotion_layout), NoDataViewFactory.d.b(NoDataViewFactory.ImgType.CREATE, g2), null, null);
                this.f17232e = a2;
                a2.setVisibility(0);
                f();
            }
            TextView textView = this.f17235h;
            textView.setText(this.m + "吧");
            UserBfbInfo userBfbInfo2 = this.l;
            if (userBfbInfo2 != null && userBfbInfo2.res_no.intValue() == 9528) {
                if (this.l.activity_status.intValue() == 0) {
                    this.k.setImageResource(R.drawable.icon_create_attention_n);
                } else {
                    this.k.setImageResource(R.drawable.icon_create_complete_n);
                }
            } else {
                this.f17236i.setVisibility(4);
                this.f17237j.setVisibility(4);
            }
            this.f17236i.setVisibility(8);
            this.f17237j.setVisibility(8);
        }
    }
}
