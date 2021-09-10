package com.baidu.tbadk.core.view.itemcard.download;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.e.a.g;
import c.a.e.a.j;
import c.a.e.e.p.l;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.DownloadManagerActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.view.ScreenTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.Item;
/* loaded from: classes6.dex */
public class ItemCardDownloadButton extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DownloadData A;
    public String B;
    public String C;
    public View.OnClickListener D;
    public e E;
    public PermissionJudgePolicy F;
    public BdUniqueId G;
    public final CustomMessageListener H;
    public final CustomMessageListener I;

    /* renamed from: e  reason: collision with root package name */
    public boolean f47964e;

    /* renamed from: f  reason: collision with root package name */
    public String f47965f;

    /* renamed from: g  reason: collision with root package name */
    public int f47966g;

    /* renamed from: h  reason: collision with root package name */
    public int f47967h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f47968i;

    /* renamed from: j  reason: collision with root package name */
    public int f47969j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public boolean x;
    public int y;
    public Item z;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ItemCardDownloadButton f47970a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ItemCardDownloadButton itemCardDownloadButton, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemCardDownloadButton, Integer.valueOf(i2)};
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
            this.f47970a = itemCardDownloadButton;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.f47970a.A != null && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage)) {
                List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                if (ListUtils.isEmpty(data)) {
                    return;
                }
                for (DownloadData downloadData : data) {
                    if (this.f47970a.A.getId().equals(downloadData.getId())) {
                        int status = downloadData.getStatus();
                        if (status == 1) {
                            this.f47970a.f47966g = downloadData.getProcess();
                            this.f47970a.y = 4;
                        } else if (status == 2 || status == 4) {
                            this.f47970a.f47966g = downloadData.getProcess();
                            this.f47970a.A.setStatus(7);
                            this.f47970a.y = 5;
                        } else if (status != 5) {
                            this.f47970a.v();
                        } else {
                            ItemCardDownloadButton itemCardDownloadButton = this.f47970a;
                            itemCardDownloadButton.f47966g = c.a.q0.e0.a.g(itemCardDownloadButton.A);
                            this.f47970a.y = 4;
                        }
                        this.f47970a.w();
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ItemCardDownloadButton f47971a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ItemCardDownloadButton itemCardDownloadButton, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemCardDownloadButton, Integer.valueOf(i2)};
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
            this.f47971a = itemCardDownloadButton;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f47971a.A == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Intent) {
                if (this.f47971a.z.apk_name.equals(c.a.q0.e0.a.f((Intent) data))) {
                    this.f47971a.v();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ItemCardDownloadButton f47972e;

        public c(ItemCardDownloadButton itemCardDownloadButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemCardDownloadButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47972e = itemCardDownloadButton;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f47972e.y == 0) {
                    if (this.f47972e.D != null) {
                        this.f47972e.D.onClick(view);
                        return;
                    }
                    return;
                }
                this.f47972e.p();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements PermissionJudgePolicy.OnPermissionsGrantedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ItemCardDownloadButton f47973a;

        /* loaded from: classes6.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f47974e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f47975f;

            public a(d dVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47975f = dVar;
                this.f47974e = str;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    ItemCardHelper.h(2, this.f47974e, this.f47975f.f47973a.z.item_id.longValue());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new DownloadManagerActivityConfig(this.f47975f.f47973a.getContext(), 3)));
                }
            }
        }

        public d(ItemCardDownloadButton itemCardDownloadButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemCardDownloadButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47973a = itemCardDownloadButton;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f47973a.A == null) {
                return;
            }
            if (this.f47973a.y == 2 || this.f47973a.y == 1) {
                String simpleName = ((Activity) this.f47973a.getContext()).getClass().getSimpleName();
                if (!"DownloadManagerActivity".equals(simpleName) && c.a.q0.s.d0.b.j().g("key_download_manager_first_toast", true)) {
                    c.a.q0.s.d0.b.j().t("key_download_manager_first_toast", false);
                    ItemCardHelper.h(1, simpleName, this.f47973a.z.item_id.longValue());
                    new ScreenTopToast(this.f47973a.getContext()).setTitle(this.f47973a.getContext().getString(R.string.item_first_use_download_manager_toast)).setBtnText(this.f47973a.getContext().getString(R.string.dialog_confirm_see)).setBtnClickListener(new a(this, simpleName)).show((ViewGroup) ((Activity) this.f47973a.getContext()).findViewById(16908290));
                }
            }
            if (!(this.f47973a.A.getExtra() instanceof ItemDownloadExtraData) || !((ItemDownloadExtraData) this.f47973a.A.getExtra()).isShouzhuData()) {
                c.a.q0.e0.a.k(this.f47973a.A);
            } else if (this.f47973a.y == 5) {
                c.a.q0.s.f0.p.d.b.a(this.f47973a.A, 500);
                c.a.q0.s.f0.p.d.a.f().d(this.f47973a.z, this.f47973a.A, this.f47973a.B, this.f47973a.G);
            } else {
                c.a.q0.s.f0.p.d.b.a(this.f47973a.A, 200);
                c.a.q0.s.f0.p.d.a.f().e(this.f47973a.z, this.f47973a.A, this.f47973a.B, this.f47973a.G);
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface e {
        void onClick(int i2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ItemCardDownloadButton(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public Item getCurrentItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.z : (Item) invokeV.objValue;
    }

    public int getObjTypeByDownloadMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            switch (this.y) {
                case 1:
                    if (ItemCardHelper.f47952b.equals(this.z.button_name)) {
                        return 2;
                    }
                    return ItemCardHelper.f47953c.equals(this.z.button_name) ? 10 : -1;
                case 2:
                    return 6;
                case 3:
                    return 4;
                case 4:
                    return 8;
                case 5:
                    return 7;
                case 6:
                    return 5;
                default:
                    return -1;
            }
        }
        return invokeV.intValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.F == null) {
                PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
                this.F = permissionJudgePolicy;
                permissionJudgePolicy.setOnPermissionsGrantedListener(new d(this));
            }
            if (getContext() instanceof Activity) {
                this.F.clearRequestPermissionList();
                this.F.appendRequestPermission((Activity) getContext(), "android.permission.WRITE_EXTERNAL_STORAGE");
                this.F.startRequestPermission((Activity) getContext());
            }
        }
    }

    public final void m(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            this.f47968i.setColor(this.f47969j);
            this.f47968i.setAlpha((int) ((this.f47964e ? SkinManager.RESOURCE_ALPHA_PRESS * 255.0f : 255.0f) * 0.5f));
            this.f47968i.setStyle(Paint.Style.STROKE);
            this.f47968i.setStrokeWidth(this.k);
            this.f47968i.setShadowLayer(this.u, this.s, this.t, this.r);
            canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.f47968i);
            this.f47968i.clearShadowLayer();
            this.f47968i.setColor(this.f47969j);
            this.f47968i.setAlpha(this.f47964e ? (int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f) : 255);
            this.f47968i.setStyle(Paint.Style.FILL);
            this.f47968i.setTextAlign(Paint.Align.CENTER);
            Paint.FontMetrics fontMetrics = this.f47968i.getFontMetrics();
            canvas.drawText(this.f47965f, getWidth() >> 1, ((int) ((getHeight() - fontMetrics.top) - fontMetrics.bottom)) >> 1, this.f47968i);
        }
    }

    public final void n(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, canvas) == null) {
            if (this.v != 0) {
                this.f47968i.setColor(this.w);
                this.f47968i.setAlpha(255);
                this.f47968i.setStyle(Paint.Style.FILL_AND_STROKE);
                this.f47968i.setShadowLayer(this.u, this.s, this.t, this.r);
                canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.f47968i);
                this.f47968i.clearShadowLayer();
            }
            int i2 = this.f47967h;
            if (i2 != 1 && i2 != 4) {
                this.f47968i.setAlpha((int) ((this.f47964e ? SkinManager.RESOURCE_ALPHA_PRESS * 255.0f : 255.0f) * 0.25f));
            } else {
                this.f47968i.setAlpha((int) ((this.f47964e ? SkinManager.RESOURCE_ALPHA_PRESS * 255.0f : 255.0f) * 0.5f));
            }
            this.f47968i.setColor(this.o);
            this.f47968i.setStyle(Paint.Style.STROKE);
            this.f47968i.setStrokeWidth(this.k);
            this.f47968i.setShadowLayer(this.u, this.s, this.t, this.r);
            canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.f47968i);
            this.f47968i.clearShadowLayer();
            this.f47968i.setColor(this.n);
            this.f47968i.setAlpha((int) ((this.f47964e ? SkinManager.RESOURCE_ALPHA_PRESS * 255.0f : 255.0f) * 0.5f));
            this.f47968i.setStyle(Paint.Style.FILL);
            this.f47968i.setStrokeWidth(this.k);
            this.f47968i.setShadowLayer(this.u, this.s, this.t, this.r);
            canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.f47968i);
            this.f47968i.clearShadowLayer();
            this.f47968i.setColor(this.p);
            this.f47968i.setAlpha(this.f47964e ? (int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f) : 255);
            this.f47968i.setStyle(Paint.Style.FILL);
            this.f47968i.setTextAlign(Paint.Align.CENTER);
            Paint.FontMetrics fontMetrics = this.f47968i.getFontMetrics();
            canvas.drawText(this.f47965f, getWidth() >> 1, ((int) ((getHeight() - fontMetrics.top) - fontMetrics.bottom)) >> 1, this.f47968i);
        }
    }

    public final void o(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, canvas) == null) {
            if (this.v != 0) {
                this.f47968i.setColor(this.w);
                this.f47968i.setAlpha(255);
                this.f47968i.setStyle(Paint.Style.FILL_AND_STROKE);
                this.f47968i.setShadowLayer(this.u, this.s, this.t, this.r);
                canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.f47968i);
                this.f47968i.clearShadowLayer();
            }
            int width = (getWidth() * this.f47966g) / 100;
            canvas.save();
            canvas.clipRect(width, 0, getWidth(), getHeight());
            this.f47968i.setColor(this.m);
            this.f47968i.setAlpha((int) ((this.f47964e ? SkinManager.RESOURCE_ALPHA_PRESS * 255.0f : 255.0f) * 0.08f));
            this.f47968i.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.f47968i);
            this.f47968i.setColor(this.m);
            this.f47968i.setAlpha(this.f47964e ? (int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f) : 255);
            this.f47968i.setStyle(Paint.Style.FILL);
            this.f47968i.setTextAlign(Paint.Align.CENTER);
            Paint.FontMetrics fontMetrics = this.f47968i.getFontMetrics();
            float height = ((int) ((getHeight() - fontMetrics.top) - fontMetrics.bottom)) >> 1;
            canvas.drawText(this.f47965f, getWidth() >> 1, height, this.f47968i);
            canvas.restore();
            canvas.save();
            canvas.clipRect(0, 0, width, getHeight());
            this.f47968i.setColor(this.m);
            this.f47968i.setAlpha((int) (this.f47964e ? SkinManager.RESOURCE_ALPHA_PRESS * 255.0f : 255.0f));
            this.f47968i.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.f47968i);
            this.f47968i.setColor(this.l);
            this.f47968i.setAlpha(this.f47964e ? (int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f) : 255);
            this.f47968i.setStyle(Paint.Style.FILL);
            this.f47968i.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.f47965f, getWidth() >> 1, height, this.f47968i);
            canvas.restore();
            if (this.f47967h != 0) {
                this.f47968i.setColor(this.l);
                this.f47968i.setAlpha(this.f47964e ? (int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f) : 255);
                this.f47968i.setStyle(Paint.Style.FILL);
                this.f47968i.setTextAlign(Paint.Align.CENTER);
                canvas.drawText(this.f47965f, getWidth() >> 1, height, this.f47968i);
            }
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f47967h = TbadkCoreApplication.getInst().getSkinType();
            this.n = SkinManager.getColor(R.color.CAM_X0209);
            int i2 = this.f47967h;
            if (i2 != 1 && i2 != 4) {
                int i3 = this.v;
                if (i3 != 0) {
                    this.p = i3;
                    this.o = i3;
                } else {
                    this.p = SkinManager.getColor(R.color.CAM_X0304);
                    this.o = SkinManager.getColor(R.color.CAM_X0304);
                }
            } else {
                this.o = SkinManager.getColor(R.color.CAM_X0209);
                this.p = SkinManager.getColor(R.color.CAM_X0103);
            }
            this.r = SkinManager.getColor(this.q);
            this.f47969j = SkinManager.getColor(R.color.CAM_X0304);
            this.m = SkinManager.getColor(R.color.CAM_X0303);
            this.l = SkinManager.getColor(R.color.CAM_X0101);
            this.w = SkinManager.getColor(R.color.CAM_X0201);
            int i4 = this.v;
            if (i4 != 0) {
                this.f47969j = i4;
                this.m = i4;
            }
            postInvalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.z == null) {
                return;
            }
            if (this.y == 6 && this.x) {
                n(canvas);
                return;
            }
            int i2 = this.y;
            if ((i2 == 0 || i2 == 1 || i2 == 2 || i2 == 6) && this.v == 0) {
                m(canvas);
            } else {
                o(canvas);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f47964e = true;
                postInvalidate();
            } else if (action == 1 || action == 3) {
                this.f47964e = false;
                postInvalidate();
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            e eVar = this.E;
            if (eVar != null) {
                eVar.onClick(this.y);
            }
            switch (this.y) {
                case 1:
                case 2:
                    CustomMessage customMessage = new CustomMessage(2921627, this.z);
                    if (j.a(getContext()) != null) {
                        customMessage.setTag(j.a(getContext()).getUniqueId());
                    }
                    MessageManager.getInstance().sendMessage(customMessage);
                    break;
                case 3:
                    c.a.q0.e0.a.h(this.A);
                    return;
                case 4:
                    c.a.q0.e0.a.a(this.A);
                    return;
                case 5:
                    break;
                case 6:
                    c.a.q0.s.f0.p.d.b.a(this.A, 1000);
                    c.a.q0.e0.a.j(this.z.apk_name);
                    return;
                default:
                    return;
            }
            l();
        }
    }

    public final boolean q(@NonNull DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, downloadData)) == null) {
            int c2 = c.a.q0.e0.a.c(downloadData);
            int g2 = c.a.q0.e0.a.g(downloadData);
            this.f47966g = g2;
            if (c2 != 5 && c2 != 1) {
                if ((g2 <= 0 || g2 > 100) && !(this.f47966g == 0 && c2 == 7)) {
                    return false;
                }
                this.y = 5;
                return true;
            }
            this.y = 4;
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean r(@NonNull DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, downloadData)) == null) {
            if (c.a.q0.e0.a.b(downloadData.getId())) {
                this.y = 3;
                this.f47966g = 100;
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean s(@NonNull Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, item)) == null) {
            PackageInfo d2 = c.a.q0.e0.a.d(item.apk_name);
            if (d2 == null || d2.versionCode < item.apk_detail.version_code.intValue()) {
                return false;
            }
            this.y = 6;
            this.f47966g = 100;
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setClickCallback(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, eVar) == null) {
            this.E = eVar;
        }
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            this.D = onClickListener;
        }
    }

    public void setCustomColorBtn(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.v = i2;
            if (i2 == 0) {
                this.f47968i.setTextSize(l.g(getContext(), R.dimen.T_X08));
            } else {
                this.f47968i.setTextSize(l.g(getContext(), R.dimen.T_X07));
            }
            postInvalidate();
        }
    }

    public void setData(@NonNull Item item, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048594, this, item, i2, str) == null) {
            this.z = item;
            this.B = str;
            if (!ItemCardHelper.w(item)) {
                this.y = 0;
                this.f47966g = this.v != 0 ? 100 : 0;
                this.A = null;
            } else {
                DownloadData i3 = c.a.q0.e0.a.i(item);
                this.A = i3;
                if (i3.getExtra() instanceof ItemDownloadExtraData) {
                    ((ItemDownloadExtraData) this.A.getExtra()).updateSceneCategory(i2);
                }
                if (!s(item) && !t(item) && !r(this.A) && !q(this.A)) {
                    this.y = 1;
                    this.f47966g = this.v != 0 ? 100 : 0;
                }
            }
            w();
            onChangeSkinType();
            c.a.q0.s.f0.p.d.b.a(this.A, 100);
        }
    }

    public void setShadow(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            String[] H = c.a.q0.s.u.a.H(i2);
            int identifier = TbadkCoreApplication.getInst().getResources().getIdentifier(H[0], "color", TbadkCoreApplication.getInst().getPackageName());
            this.q = identifier;
            this.r = SkinManager.getColor(identifier);
            Resources resources = TbadkCoreApplication.getInst().getResources();
            Resources resources2 = TbadkCoreApplication.getInst().getResources();
            this.u = resources.getDimensionPixelSize(resources2.getIdentifier("tbds" + H[1], "dimen", TbadkCoreApplication.getInst().getPackageName()));
            String[] split = H[2].split(",");
            Resources resources3 = TbadkCoreApplication.getInst().getResources();
            Resources resources4 = TbadkCoreApplication.getInst().getResources();
            this.s = resources3.getDimensionPixelSize(resources4.getIdentifier("tbds" + split[0], "dimen", TbadkCoreApplication.getInst().getPackageName()));
            Resources resources5 = TbadkCoreApplication.getInst().getResources();
            Resources resources6 = TbadkCoreApplication.getInst().getResources();
            this.t = resources5.getDimensionPixelSize(resources6.getIdentifier("tbds" + split[1], "dimen", TbadkCoreApplication.getInst().getPackageName()));
            postInvalidate();
        }
    }

    public void setTag(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bdUniqueId) == null) {
            this.G = bdUniqueId;
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.C = str;
            w();
        }
    }

    public final boolean t(@NonNull Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, item)) == null) {
            PackageInfo d2 = c.a.q0.e0.a.d(item.apk_name);
            if (d2 == null || d2.versionCode >= item.apk_detail.version_code.intValue()) {
                return false;
            }
            this.y = 2;
            this.f47966g = this.v != 0 ? 100 : 0;
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void u(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, context) == null) {
            Paint paint = new Paint(1);
            this.f47968i = paint;
            paint.setTextSize(l.g(getContext(), R.dimen.T_X08));
            this.k = l.g(getContext(), R.dimen.L_X01);
            onChangeSkinType();
            setOnClickListener(new c(this));
            if (context instanceof g) {
                g gVar = (g) context;
                gVar.getPageContext().registerListener(this.H);
                gVar.getPageContext().registerListener(this.I);
            }
        }
    }

    public void useOpenSpecialView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.x = true;
            postInvalidate();
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (!s(this.z) && !t(this.z) && !r(this.A) && !q(this.A)) {
                this.y = 1;
                this.f47966g = this.v == 0 ? 0 : 100;
            }
            w();
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            int i2 = this.y;
            if (i2 == 0) {
                this.f47965f = TextUtils.isEmpty(this.C) ? this.z.button_name : this.C;
            } else if (i2 == 2) {
                this.f47965f = getResources().getString(R.string.item_download_update);
            } else if (i2 == 3) {
                this.f47965f = getResources().getString(R.string.item_download_install);
            } else if (i2 == 4) {
                this.f47965f = String.format(getResources().getString(R.string.item_download_progress), Integer.valueOf(this.f47966g));
            } else if (i2 != 5) {
                if (i2 != 6) {
                    this.f47965f = this.z.button_name;
                } else {
                    this.f47965f = getResources().getString(R.string.item_download_open);
                }
            } else if (this.v == 0) {
                this.f47965f = getResources().getString(R.string.item_download_pause);
            } else {
                this.f47965f = getResources().getString(R.string.go_on_download);
            }
            postInvalidate();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ItemCardDownloadButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public BdUniqueId getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.G : (BdUniqueId) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemCardDownloadButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f47967h = 0;
        this.x = false;
        this.G = BdUniqueId.gen();
        this.H = new a(this, 2001118);
        this.I = new b(this, 2002504);
        u(context);
    }
}
