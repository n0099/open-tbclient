package c.a.r0.y3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.e.e.p.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.SendVideoSuccessShareModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f29085a;

    /* renamed from: b  reason: collision with root package name */
    public Context f29086b;

    /* renamed from: c  reason: collision with root package name */
    public View f29087c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f29088d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f29089e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f29090f;

    /* renamed from: g  reason: collision with root package name */
    public PostWriteCallBackData f29091g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f29092h;

    /* renamed from: i  reason: collision with root package name */
    public SendVideoSuccessShareModel f29093i;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f29094e;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29094e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f29094e.f29090f) {
                this.f29094e.f();
                if (this.f29094e.f29091g == null || StringUtils.isNull(this.f29094e.f29091g.buildVideoFakeOnWallUrl())) {
                    return;
                }
                c.a.q0.m.a.m(this.f29094e.f29086b, null, this.f29094e.f29091g.buildVideoFakeOnWallUrl());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f29095e;

        /* loaded from: classes4.dex */
        public class a extends c.a.e.a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f29096a;

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
                this.f29096a = bVar;
            }

            @Override // c.a.e.a.e
            public void c(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                    ShareItem shareItem = new ShareItem();
                    shareItem.d0 = false;
                    shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo((OriginalThreadInfo) obj);
                    c.a.r0.f0.f.b().k(new ShareDialogConfig(this.f29096a.f29095e.f29086b, shareItem, true, true));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("uid", TbadkCoreApplication.getCurrentAccount()).param(TiebaStatic.Params.OBJ_PARAM2, 1).param(TiebaStatic.Params.OBJ_PARAM3, 1));
                }
            }
        }

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29095e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f29095e.f();
                if (this.f29095e.f29091g == null || StringUtils.isNull(this.f29095e.f29091g.getVideoid())) {
                    return;
                }
                this.f29095e.f29093i.y(this.f29095e.f29091g.getVideoid());
                this.f29095e.f29093i.setLoadDataCallBack(new a(this));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f29097e;

        public c(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29097e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f29097e.f();
            }
        }
    }

    public e(Context context, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f29086b = context;
        this.f29087c = viewGroup;
        this.f29093i = new SendVideoSuccessShareModel();
        if (this.f29086b == null || this.f29087c == null) {
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.send_video_success_tip, (ViewGroup) null);
        this.f29085a = inflate;
        this.f29088d = (TextView) inflate.findViewById(R.id.success_tip);
        this.f29089e = (ImageView) this.f29085a.findViewById(R.id.video_activity_btn);
        this.f29092h = (TextView) this.f29085a.findViewById(R.id.video_share_btn);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.g(context, R.dimen.ds128));
        if (this.f29085a.getParent() == null) {
            viewGroup.addView(this.f29085a, layoutParams);
        }
        this.f29085a.setVisibility(8);
        this.f29085a.setOnClickListener(new a(this));
        this.f29092h.setOnClickListener(new b(this));
    }

    public void e() {
        SendVideoSuccessShareModel sendVideoSuccessShareModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (sendVideoSuccessShareModel = this.f29093i) == null) {
            return;
        }
        sendVideoSuccessShareModel.cancelLoadData();
    }

    public void f() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (view = this.f29085a) == null) {
            return;
        }
        view.setVisibility(8);
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, postWriteCallBackData) == null) || postWriteCallBackData == null) {
            return;
        }
        this.f29091g = postWriteCallBackData;
        this.f29090f = postWriteCallBackData.mVideoTitleData != null;
        View view = this.f29085a;
        if (view == null || this.f29088d == null || this.f29089e == null || this.f29092h == null) {
            return;
        }
        SkinManager.setBackgroundColor(view, R.color.CAM_X0302);
        SkinManager.setViewTextColor(this.f29088d, R.color.CAM_X0101);
        SkinManager.setImageResource(this.f29089e, R.drawable.icon_arrow_more_white);
        SkinManager.setBackgroundResource(this.f29092h, R.drawable.immediately_share_background);
        this.f29085a.setVisibility(0);
        this.f29085a.postDelayed(new c(this), 5000L);
        if (this.f29090f) {
            this.f29088d.setText(R.string.video_activity_tip);
        } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
            this.f29088d.setText(postWriteCallBackData.getErrorString());
        } else {
            this.f29085a.setVisibility(8);
        }
    }
}
