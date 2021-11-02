package b.a.r0.q1;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.r0.l3.w;
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
/* loaded from: classes5.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final NavigationBar f22583a;

    /* renamed from: b  reason: collision with root package name */
    public final RelativeLayout f22584b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f22585c;

    /* renamed from: d  reason: collision with root package name */
    public final TbImageView f22586d;

    /* renamed from: e  reason: collision with root package name */
    public final View f22587e;

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f22588f;

    /* renamed from: g  reason: collision with root package name */
    public final TbImageView f22589g;

    /* renamed from: h  reason: collision with root package name */
    public final TbImageView f22590h;

    /* renamed from: i  reason: collision with root package name */
    public final TbImageView f22591i;
    public final List<TbImageView> j;
    public LegoListActivity k;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f22592e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f22593f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ j f22594g;

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
            this.f22594g = jVar;
            this.f22592e = str;
            this.f22593f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22594g.f(this.f22592e, this.f22593f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f22595e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f22596f;

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
            this.f22596f = jVar;
            this.f22595e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22596f.e(this.f22595e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f22597e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f22598f;

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
            this.f22598f = jVar;
            this.f22597e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                w.c(this.f22598f.k.getPageContext(), this.f22597e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.q1.p.d f22599e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f22600f;

        public d(j jVar, b.a.r0.q1.p.d dVar) {
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
            this.f22600f = jVar;
            this.f22599e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f22600f.h(this.f22599e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f22601e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f22602f;

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
            this.f22602f = jVar;
            this.f22601e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b.a.e.e.p.a.a(this.f22601e.t);
                b.a.e.e.p.l.M(this.f22602f.k.getActivity(), view.getResources().getString(R.string.copy_pb_url_success));
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
        this.f22583a = navigationBar;
        this.f22587e = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, legoListActivity.mCommonOnClickListener);
        this.f22584b = (RelativeLayout) this.f22583a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.title_textview, (View.OnClickListener) null);
        ((LinearLayout) this.f22583a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_CENTER)).setGravity(17);
        this.f22585c = (TextView) this.f22584b.findViewById(R.id.lego_title);
        this.f22586d = (TbImageView) this.f22584b.findViewById(R.id.lego_title_img);
        LinearLayout linearLayout = (LinearLayout) this.f22584b.findViewById(R.id.ll_right);
        this.f22588f = linearLayout;
        this.f22589g = (TbImageView) linearLayout.findViewById(R.id.iv1);
        this.f22590h = (TbImageView) this.f22588f.findViewById(R.id.iv2);
        this.f22591i = (TbImageView) this.f22588f.findViewById(R.id.iv3);
        ArrayList arrayList = new ArrayList();
        this.j = arrayList;
        arrayList.add(this.f22589g);
        this.j.add(this.f22590h);
        this.j.add(this.f22591i);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f22583a.setVisibility(8);
        }
    }

    public final void e(List<b.a.r0.q1.p.d> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.f22588f.setVisibility(0);
        for (int i2 = 0; i2 < list.size() && i2 < this.j.size(); i2++) {
            this.j.get(i2).setVisibility(0);
            if (list.get(i2).f22733d == 2) {
                SkinManager.setImageResource(this.j.get(i2), R.drawable.icon_nav_share_n);
            } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.j.get(i2).startLoad(list.get(i2).f22731b, 10, false);
            } else {
                this.j.get(i2).startLoad(list.get(i2).f22730a, 10, false);
            }
            if (!TextUtils.isEmpty(list.get(i2).f22732c)) {
                String str = list.get(i2).f22732c;
                if (list.get(i2).f22733d == 1) {
                    this.j.get(i2).setOnClickListener(new c(this, str));
                } else if (list.get(i2).f22733d == 2) {
                    this.j.get(i2).setOnClickListener(new d(this, list.get(i2)));
                }
            }
        }
        for (int size = list.size(); size < this.j.size(); size++) {
            this.j.get(size).setVisibility(8);
        }
    }

    public final void f(String str, String str2) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) || (tbImageView = this.f22586d) == null || this.f22585c == null) {
            return;
        }
        tbImageView.setVisibility(0);
        this.f22585c.setVisibility(8);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.f22586d.startLoad(str2, 10, false);
        } else {
            this.f22586d.startLoad(str, 10, false);
        }
    }

    public void g(List<b.a.r0.q1.p.d> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            if (ListUtils.isEmpty(list)) {
                this.f22588f.setVisibility(8);
                return;
            }
            e(list);
            this.f22588f.postDelayed(new b(this, list), 1000L);
        }
    }

    public void h(b.a.r0.q1.p.d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) && dVar != null && dVar.f22733d == 2) {
            String str = dVar.f22736g;
            Uri parse = str == null ? null : Uri.parse(str);
            ShareItem shareItem = new ShareItem();
            shareItem.r = dVar.f22734e;
            shareItem.s = dVar.f22735f;
            shareItem.t = dVar.f22732c;
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
            SkinManager.setViewTextColor(this.f22585c, R.color.CAM_X0105);
            this.f22585c.setVisibility(0);
            this.f22586d.setVisibility(8);
            if (!TextUtils.isEmpty(str)) {
                this.f22585c.setText(str);
            } else {
                this.f22585c.setText("");
            }
        }
    }

    public void j(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        f(str, str2);
        this.f22586d.postDelayed(new a(this, str, str2), 1000L);
    }
}
