package c.a.q0.o1;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.q0.i3.v;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.activity.LegoListActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final NavigationBar f22910a;

    /* renamed from: b  reason: collision with root package name */
    public final RelativeLayout f22911b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f22912c;

    /* renamed from: d  reason: collision with root package name */
    public final TbImageView f22913d;

    /* renamed from: e  reason: collision with root package name */
    public final View f22914e;

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f22915f;

    /* renamed from: g  reason: collision with root package name */
    public final TbImageView f22916g;

    /* renamed from: h  reason: collision with root package name */
    public final TbImageView f22917h;

    /* renamed from: i  reason: collision with root package name */
    public final TbImageView f22918i;

    /* renamed from: j  reason: collision with root package name */
    public final List<TbImageView> f22919j;
    public LegoListActivity k;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f22920e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f22921f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ j f22922g;

        public a(j jVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22922g = jVar;
            this.f22920e = str;
            this.f22921f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22922g.f(this.f22920e, this.f22921f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f22923e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f22924f;

        public b(j jVar, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22924f = jVar;
            this.f22923e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22924f.e(this.f22923e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f22925e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f22926f;

        public c(j jVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22926f = jVar;
            this.f22925e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                v.c(this.f22926f.k.getPageContext(), this.f22925e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.o1.p.d f22927e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f22928f;

        public d(j jVar, c.a.q0.o1.p.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22928f = jVar;
            this.f22927e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f22928f.h(this.f22927e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f22929e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f22930f;

        public e(j jVar, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22930f = jVar;
            this.f22929e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.e.e.p.a.a(this.f22929e.t);
                c.a.e.e.p.l.M(this.f22930f.k.getActivity(), view.getResources().getString(R.string.copy_pb_url_success));
            }
        }
    }

    public j(LegoListActivity legoListActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {legoListActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = legoListActivity;
        NavigationBar navigationBar = (NavigationBar) legoListActivity.findViewById(R.id.view_navigation_bar);
        this.f22910a = navigationBar;
        this.f22914e = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, legoListActivity.mCommonOnClickListener);
        this.f22911b = (RelativeLayout) this.f22910a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.title_textview, (View.OnClickListener) null);
        ((LinearLayout) this.f22910a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_CENTER)).setGravity(17);
        this.f22912c = (TextView) this.f22911b.findViewById(R.id.lego_title);
        this.f22913d = (TbImageView) this.f22911b.findViewById(R.id.lego_title_img);
        LinearLayout linearLayout = (LinearLayout) this.f22911b.findViewById(R.id.ll_right);
        this.f22915f = linearLayout;
        this.f22916g = (TbImageView) linearLayout.findViewById(R.id.iv1);
        this.f22917h = (TbImageView) this.f22915f.findViewById(R.id.iv2);
        this.f22918i = (TbImageView) this.f22915f.findViewById(R.id.iv3);
        ArrayList arrayList = new ArrayList();
        this.f22919j = arrayList;
        arrayList.add(this.f22916g);
        this.f22919j.add(this.f22917h);
        this.f22919j.add(this.f22918i);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f22910a.setVisibility(8);
        }
    }

    public final void e(List<c.a.q0.o1.p.d> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.f22915f.setVisibility(0);
        for (int i2 = 0; i2 < list.size() && i2 < this.f22919j.size(); i2++) {
            this.f22919j.get(i2).setVisibility(0);
            if (list.get(i2).f23067d == 2) {
                SkinManager.setImageResource(this.f22919j.get(i2), R.drawable.icon_nav_share_n);
            } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.f22919j.get(i2).startLoad(list.get(i2).f23065b, 10, false);
            } else {
                this.f22919j.get(i2).startLoad(list.get(i2).f23064a, 10, false);
            }
            if (!TextUtils.isEmpty(list.get(i2).f23066c)) {
                String str = list.get(i2).f23066c;
                if (list.get(i2).f23067d == 1) {
                    this.f22919j.get(i2).setOnClickListener(new c(this, str));
                } else if (list.get(i2).f23067d == 2) {
                    this.f22919j.get(i2).setOnClickListener(new d(this, list.get(i2)));
                }
            }
        }
        for (int size = list.size(); size < this.f22919j.size(); size++) {
            this.f22919j.get(size).setVisibility(8);
        }
    }

    public final void f(String str, String str2) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) || (tbImageView = this.f22913d) == null || this.f22912c == null) {
            return;
        }
        tbImageView.setVisibility(0);
        this.f22912c.setVisibility(8);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.f22913d.startLoad(str2, 10, false);
        } else {
            this.f22913d.startLoad(str, 10, false);
        }
    }

    public void g(List<c.a.q0.o1.p.d> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            if (ListUtils.isEmpty(list)) {
                this.f22915f.setVisibility(8);
                return;
            }
            e(list);
            this.f22915f.postDelayed(new b(this, list), 1000L);
        }
    }

    public void h(c.a.q0.o1.p.d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) && dVar != null && dVar.f23067d == 2) {
            String str = dVar.f23070g;
            Uri parse = str == null ? null : Uri.parse(str);
            ShareItem shareItem = new ShareItem();
            shareItem.r = dVar.f23068e;
            shareItem.s = dVar.f23069f;
            shareItem.t = dVar.f23066c;
            if (parse != null) {
                shareItem.v = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.k.getActivity(), shareItem, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new e(this, shareItem));
            this.k.sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            SkinManager.setViewTextColor(this.f22912c, R.color.CAM_X0105);
            this.f22912c.setVisibility(0);
            this.f22913d.setVisibility(8);
            if (!TextUtils.isEmpty(str)) {
                this.f22912c.setText(str);
            } else {
                this.f22912c.setText("");
            }
        }
    }

    public void j(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        f(str, str2);
        this.f22913d.postDelayed(new a(this, str, str2), 1000L);
    }
}
