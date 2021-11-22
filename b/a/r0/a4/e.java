package b.a.r0.a4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import b.a.e.f.p.l;
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
    public View f15925a;

    /* renamed from: b  reason: collision with root package name */
    public Context f15926b;

    /* renamed from: c  reason: collision with root package name */
    public View f15927c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f15928d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f15929e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f15930f;

    /* renamed from: g  reason: collision with root package name */
    public PostWriteCallBackData f15931g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f15932h;

    /* renamed from: i  reason: collision with root package name */
    public SendVideoSuccessShareModel f15933i;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f15934e;

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
            this.f15934e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f15934e.f15930f) {
                this.f15934e.f();
                if (this.f15934e.f15931g == null || StringUtils.isNull(this.f15934e.f15931g.buildVideoFakeOnWallUrl())) {
                    return;
                }
                b.a.q0.m.a.n(this.f15934e.f15926b, null, this.f15934e.f15931g.buildVideoFakeOnWallUrl());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f15935e;

        /* loaded from: classes4.dex */
        public class a extends b.a.e.a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f15936a;

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
                this.f15936a = bVar;
            }

            @Override // b.a.e.a.e
            public void c(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                    ShareItem shareItem = new ShareItem();
                    shareItem.d0 = false;
                    shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo((OriginalThreadInfo) obj);
                    b.a.r0.f0.h.c().l(new ShareDialogConfig(this.f15936a.f15935e.f15926b, shareItem, true, true));
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
            this.f15935e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f15935e.f();
                if (this.f15935e.f15931g == null || StringUtils.isNull(this.f15935e.f15931g.getVideoid())) {
                    return;
                }
                this.f15935e.f15933i.y(this.f15935e.f15931g.getVideoid());
                this.f15935e.f15933i.setLoadDataCallBack(new a(this));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f15937e;

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
            this.f15937e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f15937e.f();
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
        this.f15926b = context;
        this.f15927c = viewGroup;
        this.f15933i = new SendVideoSuccessShareModel();
        if (this.f15926b == null || this.f15927c == null) {
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.send_video_success_tip, (ViewGroup) null);
        this.f15925a = inflate;
        this.f15928d = (TextView) inflate.findViewById(R.id.success_tip);
        this.f15929e = (ImageView) this.f15925a.findViewById(R.id.video_activity_btn);
        this.f15932h = (TextView) this.f15925a.findViewById(R.id.video_share_btn);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.g(context, R.dimen.ds128));
        if (this.f15925a.getParent() == null) {
            viewGroup.addView(this.f15925a, layoutParams);
        }
        this.f15925a.setVisibility(8);
        this.f15925a.setOnClickListener(new a(this));
        this.f15932h.setOnClickListener(new b(this));
    }

    public void e() {
        SendVideoSuccessShareModel sendVideoSuccessShareModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (sendVideoSuccessShareModel = this.f15933i) == null) {
            return;
        }
        sendVideoSuccessShareModel.cancelLoadData();
    }

    public void f() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (view = this.f15925a) == null) {
            return;
        }
        view.setVisibility(8);
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, postWriteCallBackData) == null) || postWriteCallBackData == null) {
            return;
        }
        this.f15931g = postWriteCallBackData;
        this.f15930f = postWriteCallBackData.mVideoTitleData != null;
        View view = this.f15925a;
        if (view == null || this.f15928d == null || this.f15929e == null || this.f15932h == null) {
            return;
        }
        SkinManager.setBackgroundColor(view, R.color.CAM_X0302);
        SkinManager.setViewTextColor(this.f15928d, R.color.CAM_X0101);
        SkinManager.setImageResource(this.f15929e, R.drawable.icon_arrow_more_white);
        SkinManager.setBackgroundResource(this.f15932h, R.drawable.immediately_share_background);
        this.f15925a.setVisibility(0);
        this.f15925a.postDelayed(new c(this), 5000L);
        if (this.f15930f) {
            this.f15928d.setText(R.string.video_activity_tip);
        } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
            this.f15928d.setText(postWriteCallBackData.getErrorString());
        } else {
            this.f15925a.setVisibility(8);
        }
    }
}
