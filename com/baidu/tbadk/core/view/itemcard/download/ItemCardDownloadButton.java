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
import c.a.d.a.g;
import c.a.d.f.p.n;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.DownloadManagerActivityConfig;
import com.baidu.tbadk.core.data.ItemData;
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
/* loaded from: classes11.dex */
public class ItemCardDownloadButton extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ItemData A;
    public DownloadData B;
    public String C;
    public String D;
    public View.OnClickListener E;
    public e F;
    public PermissionJudgePolicy G;
    public BdUniqueId H;
    public boolean I;
    public final CustomMessageListener J;
    public final CustomMessageListener K;

    /* renamed from: e  reason: collision with root package name */
    public boolean f42106e;

    /* renamed from: f  reason: collision with root package name */
    public String f42107f;

    /* renamed from: g  reason: collision with root package name */
    public int f42108g;

    /* renamed from: h  reason: collision with root package name */
    public int f42109h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f42110i;

    /* renamed from: j  reason: collision with root package name */
    public int f42111j;

    /* renamed from: k  reason: collision with root package name */
    public int f42112k;
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
    public boolean y;
    public int z;

    /* loaded from: classes11.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ItemCardDownloadButton a;

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
            this.a = itemCardDownloadButton;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.B != null && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage)) {
                List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                if (ListUtils.isEmpty(data)) {
                    return;
                }
                for (DownloadData downloadData : data) {
                    if (this.a.B.getId().equals(downloadData.getId())) {
                        int status = downloadData.getStatus();
                        if (status == 1) {
                            this.a.f42108g = downloadData.getProcess();
                            this.a.z = 4;
                        } else if (status == 2 || status == 4) {
                            this.a.f42108g = downloadData.getProcess();
                            this.a.B.setStatus(7);
                            this.a.z = 5;
                        } else if (status != 5) {
                            this.a.v();
                        } else {
                            ItemCardDownloadButton itemCardDownloadButton = this.a;
                            itemCardDownloadButton.f42108g = c.a.s0.e0.a.h(itemCardDownloadButton.B);
                            this.a.z = 4;
                        }
                        this.a.w();
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ItemCardDownloadButton a;

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
            this.a = itemCardDownloadButton;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.B == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Intent) {
                if (this.a.A.pkgName.equals(c.a.s0.e0.a.g((Intent) data))) {
                    this.a.v();
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ItemCardDownloadButton f42113e;

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
            this.f42113e = itemCardDownloadButton;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f42113e.z == 0) {
                    if (this.f42113e.E != null) {
                        this.f42113e.E.onClick(view);
                        return;
                    }
                    return;
                }
                this.f42113e.p();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class d implements PermissionJudgePolicy.OnPermissionsGrantedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ItemCardDownloadButton a;

        /* loaded from: classes11.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f42114e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f42115f;

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
                this.f42115f = dVar;
                this.f42114e = str;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    ItemCardHelper.g(2, this.f42114e, this.f42115f.a.A.itemId);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new DownloadManagerActivityConfig(this.f42115f.a.getContext(), 3)));
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
            this.a = itemCardDownloadButton;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.B == null) {
                return;
            }
            if (this.a.z == 2 || this.a.z == 1) {
                String simpleName = ((Activity) this.a.getContext()).getClass().getSimpleName();
                if (!"DownloadManagerActivity".equals(simpleName) && c.a.s0.s.g0.b.j().g("key_download_manager_first_toast", true)) {
                    c.a.s0.s.g0.b.j().t("key_download_manager_first_toast", false);
                    ItemCardHelper.g(1, simpleName, this.a.A.itemId);
                    new ScreenTopToast(this.a.getContext()).setTitle(this.a.getContext().getString(R.string.item_first_use_download_manager_toast)).setBtnText(this.a.getContext().getString(R.string.dialog_confirm_see)).setBtnClickListener(new a(this, simpleName)).show((ViewGroup) ((Activity) this.a.getContext()).findViewById(16908290));
                }
            }
            if (!(this.a.B.getExtra() instanceof ItemDownloadExtraData) || !((ItemDownloadExtraData) this.a.B.getExtra()).isShouzhuData()) {
                c.a.s0.e0.a.l(this.a.B);
            } else if (this.a.z == 5) {
                c.a.s0.s.i0.p.d.b.a(this.a.B, 500);
                c.a.s0.s.i0.p.d.a.f().d(this.a.A, this.a.B, this.a.C, this.a.H);
            } else {
                c.a.s0.s.i0.p.d.b.a(this.a.B, 200);
                c.a.s0.s.i0.p.d.a.f().e(this.a.A, this.a.B, this.a.C, this.a.H);
            }
        }
    }

    /* loaded from: classes11.dex */
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

    public ItemData getCurrentItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.A : (ItemData) invokeV.objValue;
    }

    public int getObjTypeByDownloadMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            switch (this.z) {
                case 1:
                    if (ItemCardHelper.f42093b.equals(this.A.buttonName)) {
                        return 2;
                    }
                    return ItemCardHelper.f42094c.equals(this.A.buttonName) ? 10 : -1;
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
            if (this.G == null) {
                PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
                this.G = permissionJudgePolicy;
                permissionJudgePolicy.setOnPermissionsGrantedListener(new d(this));
            }
            if (getContext() instanceof Activity) {
                this.G.clearRequestPermissionList();
                this.G.appendRequestPermission((Activity) getContext(), "android.permission.WRITE_EXTERNAL_STORAGE");
                this.G.startRequestPermission((Activity) getContext());
            }
        }
    }

    public final void m(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            this.f42110i.setColor(this.f42111j);
            this.f42110i.setAlpha((int) ((this.f42106e ? SkinManager.RESOURCE_ALPHA_PRESS * 255.0f : 255.0f) * 0.5f));
            this.f42110i.setStyle(Paint.Style.STROKE);
            this.f42110i.setStrokeWidth(this.f42112k);
            this.f42110i.setShadowLayer(this.u, this.s, this.t, this.r);
            canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.f42110i);
            this.f42110i.clearShadowLayer();
            this.f42110i.setColor(this.f42111j);
            this.f42110i.setAlpha(this.f42106e ? (int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f) : 255);
            this.f42110i.setStyle(Paint.Style.FILL);
            this.f42110i.setTextAlign(Paint.Align.CENTER);
            Paint.FontMetrics fontMetrics = this.f42110i.getFontMetrics();
            canvas.drawText(this.f42107f, getWidth() >> 1, ((int) ((getHeight() - fontMetrics.top) - fontMetrics.bottom)) >> 1, this.f42110i);
        }
    }

    public final void n(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, canvas) == null) {
            if (this.v != 0) {
                this.f42110i.setColor(this.w);
                this.f42110i.setAlpha(255);
                this.f42110i.setStyle(Paint.Style.FILL_AND_STROKE);
                this.f42110i.setShadowLayer(this.u, this.s, this.t, this.r);
                canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.f42110i);
                this.f42110i.clearShadowLayer();
            }
            int i2 = this.f42109h;
            if (i2 != 1 && i2 != 4) {
                this.f42110i.setAlpha((int) ((this.f42106e ? SkinManager.RESOURCE_ALPHA_PRESS * 255.0f : 255.0f) * 0.25f));
            } else {
                this.f42110i.setAlpha((int) ((this.f42106e ? SkinManager.RESOURCE_ALPHA_PRESS * 255.0f : 255.0f) * 0.5f));
            }
            this.f42110i.setColor(this.o);
            this.f42110i.setStyle(Paint.Style.STROKE);
            this.f42110i.setStrokeWidth(this.f42112k);
            this.f42110i.setShadowLayer(this.u, this.s, this.t, this.r);
            canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.f42110i);
            this.f42110i.clearShadowLayer();
            this.f42110i.setColor(this.n);
            this.f42110i.setAlpha((int) ((this.f42106e ? SkinManager.RESOURCE_ALPHA_PRESS * 255.0f : 255.0f) * 0.5f));
            this.f42110i.setStyle(Paint.Style.FILL);
            this.f42110i.setStrokeWidth(this.f42112k);
            this.f42110i.setShadowLayer(this.u, this.s, this.t, this.r);
            canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.f42110i);
            this.f42110i.clearShadowLayer();
            this.f42110i.setColor(this.p);
            this.f42110i.setAlpha(this.f42106e ? (int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f) : 255);
            this.f42110i.setStyle(Paint.Style.FILL);
            this.f42110i.setTextAlign(Paint.Align.CENTER);
            Paint.FontMetrics fontMetrics = this.f42110i.getFontMetrics();
            canvas.drawText(this.f42107f, getWidth() >> 1, ((int) ((getHeight() - fontMetrics.top) - fontMetrics.bottom)) >> 1, this.f42110i);
        }
    }

    public final void o(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, canvas) == null) {
            if (this.v != 0) {
                this.f42110i.setColor(this.w);
                this.f42110i.setAlpha(255);
                this.f42110i.setStyle(Paint.Style.FILL_AND_STROKE);
                this.f42110i.setShadowLayer(this.u, this.s, this.t, this.r);
                canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.f42110i);
                this.f42110i.clearShadowLayer();
            }
            int width = (getWidth() * this.f42108g) / 100;
            canvas.save();
            canvas.clipRect(width, 0, getWidth(), getHeight());
            this.f42110i.setColor(this.m);
            this.f42110i.setAlpha((int) ((this.f42106e ? SkinManager.RESOURCE_ALPHA_PRESS * 255.0f : 255.0f) * 0.08f));
            this.f42110i.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.f42110i);
            this.f42110i.setColor(this.m);
            this.f42110i.setAlpha(this.f42106e ? (int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f) : 255);
            this.f42110i.setStyle(Paint.Style.FILL);
            this.f42110i.setTextAlign(Paint.Align.CENTER);
            Paint.FontMetrics fontMetrics = this.f42110i.getFontMetrics();
            float height = ((int) ((getHeight() - fontMetrics.top) - fontMetrics.bottom)) >> 1;
            canvas.drawText(this.f42107f, getWidth() >> 1, height, this.f42110i);
            canvas.restore();
            canvas.save();
            canvas.clipRect(0, 0, width, getHeight());
            this.f42110i.setColor(this.m);
            this.f42110i.setAlpha((int) (this.f42106e ? SkinManager.RESOURCE_ALPHA_PRESS * 255.0f : 255.0f));
            this.f42110i.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.f42110i);
            this.f42110i.setColor(this.l);
            this.f42110i.setAlpha(this.f42106e ? (int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f) : 255);
            this.f42110i.setStyle(Paint.Style.FILL);
            this.f42110i.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.f42107f, getWidth() >> 1, height, this.f42110i);
            canvas.restore();
            if (this.f42109h == 0 || this.I) {
                return;
            }
            this.f42110i.setColor(this.l);
            this.f42110i.setAlpha(this.f42106e ? (int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f) : 255);
            this.f42110i.setStyle(Paint.Style.FILL);
            this.f42110i.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.f42107f, getWidth() >> 1, height, this.f42110i);
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onAttachedToWindow();
            x();
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f42109h = TbadkCoreApplication.getInst().getSkinType();
            this.n = SkinManager.getColor(R.color.CAM_X0209);
            int i2 = this.f42109h;
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
            this.f42111j = SkinManager.getColor(R.color.CAM_X0304);
            this.m = SkinManager.getColor(R.color.CAM_X0303);
            this.l = SkinManager.getColor(R.color.CAM_X0101);
            this.w = SkinManager.getColor(R.color.CAM_X0201);
            int i4 = this.v;
            if (i4 != 0) {
                this.f42111j = i4;
                this.m = i4;
            }
            postInvalidate();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDetachedFromWindow();
            y();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.A == null) {
                return;
            }
            if (this.z == 6 && this.x) {
                n(canvas);
                return;
            }
            int i2 = this.z;
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f42106e = true;
                postInvalidate();
            } else if (action == 1 || action == 3) {
                this.f42106e = false;
                postInvalidate();
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            e eVar = this.F;
            if (eVar != null) {
                eVar.onClick(this.z);
            }
            switch (this.z) {
                case 1:
                case 2:
                    c.a.t0.p0.b.b bVar = new c.a.t0.p0.b.b();
                    bVar.f21941e = this.A;
                    bVar.f21942f = 1;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921627, bVar));
                    l();
                    return;
                case 3:
                    c.a.s0.e0.a.i(this.B);
                    return;
                case 4:
                    c.a.s0.e0.a.a(this.B);
                    return;
                case 5:
                    l();
                    return;
                case 6:
                    c.a.s0.s.i0.p.d.b.a(this.B, 1000);
                    c.a.s0.e0.a.k(this.A.pkgName);
                    return;
                default:
                    return;
            }
        }
    }

    public final boolean q(@NonNull DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, downloadData)) == null) {
            int c2 = c.a.s0.e0.a.c(downloadData);
            int h2 = c.a.s0.e0.a.h(downloadData);
            this.f42108g = h2;
            if (c2 != 5 && c2 != 1) {
                if ((h2 <= 0 || h2 > 100) && !(this.f42108g == 0 && c2 == 7)) {
                    return false;
                }
                this.z = 5;
                return true;
            }
            this.z = 4;
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean r(@NonNull DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, downloadData)) == null) {
            if (c.a.s0.e0.a.b(downloadData.getId())) {
                this.z = 3;
                this.f42108g = 100;
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean s(@NonNull ItemData itemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, itemData)) == null) {
            PackageInfo e2 = c.a.s0.e0.a.e(itemData.pkgName);
            if (e2 == null || e2.versionCode < itemData.apkDetail.version_code.intValue()) {
                return false;
            }
            this.z = 6;
            this.f42108g = 100;
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setClickCallback(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, eVar) == null) {
            this.F = eVar;
        }
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) {
            this.E = onClickListener;
        }
    }

    public void setCustomColorBtn(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            if (i2 == Integer.MAX_VALUE) {
                int i3 = this.f42109h;
                if (i3 != 1 && i3 != 4) {
                    i2 = SkinManager.getColor(R.color.CAM_X0303);
                } else {
                    i2 = SkinManager.getColor(R.color.CAM_X0209);
                }
            }
            setCustomColorBtn(i2, true);
        }
    }

    public void setData(@NonNull ItemData itemData, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048597, this, itemData, i2, str) == null) {
            this.A = itemData;
            this.C = str;
            if (!ItemCardHelper.w(itemData)) {
                this.z = 0;
                this.f42108g = this.v != 0 ? 100 : 0;
                this.B = null;
            } else {
                DownloadData j2 = c.a.s0.e0.a.j(itemData);
                this.B = j2;
                if (j2.getExtra() instanceof ItemDownloadExtraData) {
                    ((ItemDownloadExtraData) this.B.getExtra()).updateSceneCategory(i2);
                }
                if (!s(itemData) && !t(itemData) && !r(this.B) && !q(this.B)) {
                    this.z = 1;
                    this.f42108g = this.v != 0 ? 100 : 0;
                }
            }
            w();
            onChangeSkinType();
            c.a.s0.s.i0.p.d.b.a(this.B, 100);
        }
    }

    public void setShadow(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            String[] F = c.a.s0.s.u.a.F(i2);
            int identifier = TbadkCoreApplication.getInst().getResources().getIdentifier(F[0], "color", TbadkCoreApplication.getInst().getPackageName());
            this.q = identifier;
            this.r = SkinManager.getColor(identifier);
            Resources resources = TbadkCoreApplication.getInst().getResources();
            Resources resources2 = TbadkCoreApplication.getInst().getResources();
            this.u = resources.getDimensionPixelSize(resources2.getIdentifier("tbds" + F[1], "dimen", TbadkCoreApplication.getInst().getPackageName()));
            String[] split = F[2].split(",");
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
        if (interceptable == null || interceptable.invokeL(1048599, this, bdUniqueId) == null) {
            this.H = bdUniqueId;
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.D = str;
            w();
        }
    }

    public void setUserProgressTextGradientModel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.I = z;
        }
    }

    public final boolean t(@NonNull ItemData itemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, itemData)) == null) {
            PackageInfo e2 = c.a.s0.e0.a.e(itemData.pkgName);
            if (e2 == null || e2.versionCode >= itemData.apkDetail.version_code.intValue()) {
                return false;
            }
            this.z = 2;
            this.f42108g = this.v != 0 ? 100 : 0;
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void u(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, context) == null) {
            Paint paint = new Paint(1);
            this.f42110i = paint;
            paint.setTextSize(n.f(getContext(), R.dimen.T_X08));
            this.f42112k = n.f(getContext(), R.dimen.L_X01);
            onChangeSkinType();
            setOnClickListener(new c(this));
        }
    }

    public void useLongText() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.y = true;
        }
    }

    public void useOpenSpecialView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.x = true;
            postInvalidate();
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            if (!s(this.A) && !t(this.A) && !r(this.B) && !q(this.B)) {
                this.z = 1;
                this.f42108g = this.v == 0 ? 0 : 100;
            }
            w();
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            int i2 = this.z;
            if (i2 == 0) {
                this.f42107f = TextUtils.isEmpty(this.D) ? this.A.buttonName : this.D;
            } else if (i2 == 2) {
                this.f42107f = getResources().getString(R.string.item_download_update);
            } else if (i2 == 3) {
                this.f42107f = getResources().getString(R.string.item_download_install);
            } else if (i2 == 4) {
                this.f42107f = String.format(getResources().getString(R.string.item_download_progress), Integer.valueOf(this.f42108g));
            } else if (i2 != 5) {
                if (i2 != 6) {
                    this.f42107f = this.A.buttonName;
                } else {
                    this.f42107f = getResources().getString(R.string.item_download_open);
                }
            } else if (!this.y) {
                this.f42107f = getResources().getString(R.string.item_download_pause);
            } else {
                this.f42107f = getResources().getString(R.string.go_on_download);
            }
            postInvalidate();
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && (getContext() instanceof g)) {
            ((g) getContext()).getPageContext().registerListener(this.J);
            ((g) getContext()).getPageContext().registerListener(this.K);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.J);
            MessageManager.getInstance().unRegisterListener(this.K);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.H : (BdUniqueId) invokeV.objValue;
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
        this.f42109h = 0;
        this.x = false;
        this.y = false;
        this.H = BdUniqueId.gen();
        this.I = false;
        this.J = new a(this, 2001118);
        this.K = new b(this, 2002504);
        u(context);
    }

    public void setCustomColorBtn(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.v = i2;
            if (z) {
                if (i2 == 0) {
                    this.f42110i.setTextSize(n.f(getContext(), R.dimen.T_X08));
                } else {
                    this.f42110i.setTextSize(n.f(getContext(), R.dimen.T_X07));
                }
            }
            onChangeSkinType();
        }
    }
}
