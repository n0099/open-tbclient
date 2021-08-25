package c.a.q0.w3;

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
    public View f28202a;

    /* renamed from: b  reason: collision with root package name */
    public Context f28203b;

    /* renamed from: c  reason: collision with root package name */
    public View f28204c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f28205d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f28206e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f28207f;

    /* renamed from: g  reason: collision with root package name */
    public PostWriteCallBackData f28208g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f28209h;

    /* renamed from: i  reason: collision with root package name */
    public SendVideoSuccessShareModel f28210i;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f28211e;

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
            this.f28211e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f28211e.f28207f) {
                this.f28211e.f();
                if (this.f28211e.f28208g == null || StringUtils.isNull(this.f28211e.f28208g.buildVideoFakeOnWallUrl())) {
                    return;
                }
                c.a.p0.m.a.n(this.f28211e.f28203b, null, this.f28211e.f28208g.buildVideoFakeOnWallUrl());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f28212e;

        /* loaded from: classes4.dex */
        public class a extends c.a.e.a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f28213a;

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
                this.f28213a = bVar;
            }

            @Override // c.a.e.a.e
            public void c(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                    ShareItem shareItem = new ShareItem();
                    shareItem.a0 = false;
                    shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo((OriginalThreadInfo) obj);
                    c.a.q0.e0.f.b().k(new ShareDialogConfig(this.f28213a.f28212e.f28203b, shareItem, true, true));
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
            this.f28212e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f28212e.f();
                if (this.f28212e.f28208g == null || StringUtils.isNull(this.f28212e.f28208g.getVideoid())) {
                    return;
                }
                this.f28212e.f28210i.y(this.f28212e.f28208g.getVideoid());
                this.f28212e.f28210i.setLoadDataCallBack(new a(this));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f28214e;

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
            this.f28214e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f28214e.f();
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
        this.f28203b = context;
        this.f28204c = viewGroup;
        this.f28210i = new SendVideoSuccessShareModel();
        if (this.f28203b == null || this.f28204c == null) {
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.send_video_success_tip, (ViewGroup) null);
        this.f28202a = inflate;
        this.f28205d = (TextView) inflate.findViewById(R.id.success_tip);
        this.f28206e = (ImageView) this.f28202a.findViewById(R.id.video_activity_btn);
        this.f28209h = (TextView) this.f28202a.findViewById(R.id.video_share_btn);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.g(context, R.dimen.ds128));
        if (this.f28202a.getParent() == null) {
            viewGroup.addView(this.f28202a, layoutParams);
        }
        this.f28202a.setVisibility(8);
        this.f28202a.setOnClickListener(new a(this));
        this.f28209h.setOnClickListener(new b(this));
    }

    public void e() {
        SendVideoSuccessShareModel sendVideoSuccessShareModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (sendVideoSuccessShareModel = this.f28210i) == null) {
            return;
        }
        sendVideoSuccessShareModel.cancelLoadData();
    }

    public void f() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (view = this.f28202a) == null) {
            return;
        }
        view.setVisibility(8);
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, postWriteCallBackData) == null) || postWriteCallBackData == null) {
            return;
        }
        this.f28208g = postWriteCallBackData;
        this.f28207f = postWriteCallBackData.mVideoTitleData != null;
        View view = this.f28202a;
        if (view == null || this.f28205d == null || this.f28206e == null || this.f28209h == null) {
            return;
        }
        SkinManager.setBackgroundColor(view, R.color.CAM_X0302);
        SkinManager.setViewTextColor(this.f28205d, R.color.CAM_X0101);
        SkinManager.setImageResource(this.f28206e, R.drawable.icon_arrow_more_white);
        SkinManager.setBackgroundResource(this.f28209h, R.drawable.immediately_share_background);
        this.f28202a.setVisibility(0);
        this.f28202a.postDelayed(new c(this), 5000L);
        if (this.f28207f) {
            this.f28205d.setText(R.string.video_activity_tip);
        } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
            this.f28205d.setText(postWriteCallBackData.getErrorString());
        } else {
            this.f28202a.setVisibility(8);
        }
    }
}
