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
import c.a.e.e.p.l;
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
/* loaded from: classes6.dex */
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
    public boolean f47991e;

    /* renamed from: f  reason: collision with root package name */
    public String f47992f;

    /* renamed from: g  reason: collision with root package name */
    public int f47993g;

    /* renamed from: h  reason: collision with root package name */
    public int f47994h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f47995i;

    /* renamed from: j  reason: collision with root package name */
    public int f47996j;
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
    public boolean y;
    public int z;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ItemCardDownloadButton f47997a;

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
            this.f47997a = itemCardDownloadButton;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.f47997a.B != null && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage)) {
                List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                if (ListUtils.isEmpty(data)) {
                    return;
                }
                for (DownloadData downloadData : data) {
                    if (this.f47997a.B.getId().equals(downloadData.getId())) {
                        int status = downloadData.getStatus();
                        if (status == 1) {
                            this.f47997a.f47993g = downloadData.getProcess();
                            this.f47997a.z = 4;
                        } else if (status == 2 || status == 4) {
                            this.f47997a.f47993g = downloadData.getProcess();
                            this.f47997a.B.setStatus(7);
                            this.f47997a.z = 5;
                        } else if (status != 5) {
                            this.f47997a.v();
                        } else {
                            ItemCardDownloadButton itemCardDownloadButton = this.f47997a;
                            itemCardDownloadButton.f47993g = c.a.q0.e0.a.h(itemCardDownloadButton.B);
                            this.f47997a.z = 4;
                        }
                        this.f47997a.w();
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
        public final /* synthetic */ ItemCardDownloadButton f47998a;

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
            this.f47998a = itemCardDownloadButton;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f47998a.B == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Intent) {
                if (this.f47998a.A.pkgName.equals(c.a.q0.e0.a.g((Intent) data))) {
                    this.f47998a.v();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ItemCardDownloadButton f47999e;

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
            this.f47999e = itemCardDownloadButton;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f47999e.z == 0) {
                    if (this.f47999e.E != null) {
                        this.f47999e.E.onClick(view);
                        return;
                    }
                    return;
                }
                this.f47999e.p();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements PermissionJudgePolicy.OnPermissionsGrantedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ItemCardDownloadButton f48000a;

        /* loaded from: classes6.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f48001e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f48002f;

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
                this.f48002f = dVar;
                this.f48001e = str;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    ItemCardHelper.g(2, this.f48001e, this.f48002f.f48000a.A.itemId);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new DownloadManagerActivityConfig(this.f48002f.f48000a.getContext(), 3)));
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
            this.f48000a = itemCardDownloadButton;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f48000a.B == null) {
                return;
            }
            if (this.f48000a.z == 2 || this.f48000a.z == 1) {
                String simpleName = ((Activity) this.f48000a.getContext()).getClass().getSimpleName();
                if (!"DownloadManagerActivity".equals(simpleName) && c.a.q0.s.d0.b.j().g("key_download_manager_first_toast", true)) {
                    c.a.q0.s.d0.b.j().t("key_download_manager_first_toast", false);
                    ItemCardHelper.g(1, simpleName, this.f48000a.A.itemId);
                    new ScreenTopToast(this.f48000a.getContext()).setTitle(this.f48000a.getContext().getString(R.string.item_first_use_download_manager_toast)).setBtnText(this.f48000a.getContext().getString(R.string.dialog_confirm_see)).setBtnClickListener(new a(this, simpleName)).show((ViewGroup) ((Activity) this.f48000a.getContext()).findViewById(16908290));
                }
            }
            if (!(this.f48000a.B.getExtra() instanceof ItemDownloadExtraData) || !((ItemDownloadExtraData) this.f48000a.B.getExtra()).isShouzhuData()) {
                c.a.q0.e0.a.l(this.f48000a.B);
            } else if (this.f48000a.z == 5) {
                c.a.q0.s.f0.p.d.b.a(this.f48000a.B, 500);
                c.a.q0.s.f0.p.d.a.f().d(this.f48000a.A, this.f48000a.B, this.f48000a.C, this.f48000a.H);
            } else {
                c.a.q0.s.f0.p.d.b.a(this.f48000a.B, 200);
                c.a.q0.s.f0.p.d.a.f().e(this.f48000a.A, this.f48000a.B, this.f48000a.C, this.f48000a.H);
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
                    if (ItemCardHelper.f47979b.equals(this.A.buttonName)) {
                        return 2;
                    }
                    return ItemCardHelper.f47980c.equals(this.A.buttonName) ? 10 : -1;
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
            this.f47995i.setColor(this.f47996j);
            this.f47995i.setAlpha((int) ((this.f47991e ? SkinManager.RESOURCE_ALPHA_PRESS * 255.0f : 255.0f) * 0.5f));
            this.f47995i.setStyle(Paint.Style.STROKE);
            this.f47995i.setStrokeWidth(this.k);
            this.f47995i.setShadowLayer(this.u, this.s, this.t, this.r);
            canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.f47995i);
            this.f47995i.clearShadowLayer();
            this.f47995i.setColor(this.f47996j);
            this.f47995i.setAlpha(this.f47991e ? (int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f) : 255);
            this.f47995i.setStyle(Paint.Style.FILL);
            this.f47995i.setTextAlign(Paint.Align.CENTER);
            Paint.FontMetrics fontMetrics = this.f47995i.getFontMetrics();
            canvas.drawText(this.f47992f, getWidth() >> 1, ((int) ((getHeight() - fontMetrics.top) - fontMetrics.bottom)) >> 1, this.f47995i);
        }
    }

    public final void n(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, canvas) == null) {
            if (this.v != 0) {
                this.f47995i.setColor(this.w);
                this.f47995i.setAlpha(255);
                this.f47995i.setStyle(Paint.Style.FILL_AND_STROKE);
                this.f47995i.setShadowLayer(this.u, this.s, this.t, this.r);
                canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.f47995i);
                this.f47995i.clearShadowLayer();
            }
            int i2 = this.f47994h;
            if (i2 != 1 && i2 != 4) {
                this.f47995i.setAlpha((int) ((this.f47991e ? SkinManager.RESOURCE_ALPHA_PRESS * 255.0f : 255.0f) * 0.25f));
            } else {
                this.f47995i.setAlpha((int) ((this.f47991e ? SkinManager.RESOURCE_ALPHA_PRESS * 255.0f : 255.0f) * 0.5f));
            }
            this.f47995i.setColor(this.o);
            this.f47995i.setStyle(Paint.Style.STROKE);
            this.f47995i.setStrokeWidth(this.k);
            this.f47995i.setShadowLayer(this.u, this.s, this.t, this.r);
            canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.f47995i);
            this.f47995i.clearShadowLayer();
            this.f47995i.setColor(this.n);
            this.f47995i.setAlpha((int) ((this.f47991e ? SkinManager.RESOURCE_ALPHA_PRESS * 255.0f : 255.0f) * 0.5f));
            this.f47995i.setStyle(Paint.Style.FILL);
            this.f47995i.setStrokeWidth(this.k);
            this.f47995i.setShadowLayer(this.u, this.s, this.t, this.r);
            canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.f47995i);
            this.f47995i.clearShadowLayer();
            this.f47995i.setColor(this.p);
            this.f47995i.setAlpha(this.f47991e ? (int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f) : 255);
            this.f47995i.setStyle(Paint.Style.FILL);
            this.f47995i.setTextAlign(Paint.Align.CENTER);
            Paint.FontMetrics fontMetrics = this.f47995i.getFontMetrics();
            canvas.drawText(this.f47992f, getWidth() >> 1, ((int) ((getHeight() - fontMetrics.top) - fontMetrics.bottom)) >> 1, this.f47995i);
        }
    }

    public final void o(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, canvas) == null) {
            if (this.v != 0) {
                this.f47995i.setColor(this.w);
                this.f47995i.setAlpha(255);
                this.f47995i.setStyle(Paint.Style.FILL_AND_STROKE);
                this.f47995i.setShadowLayer(this.u, this.s, this.t, this.r);
                canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.f47995i);
                this.f47995i.clearShadowLayer();
            }
            int width = (getWidth() * this.f47993g) / 100;
            canvas.save();
            canvas.clipRect(width, 0, getWidth(), getHeight());
            this.f47995i.setColor(this.m);
            this.f47995i.setAlpha((int) ((this.f47991e ? SkinManager.RESOURCE_ALPHA_PRESS * 255.0f : 255.0f) * 0.08f));
            this.f47995i.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.f47995i);
            this.f47995i.setColor(this.m);
            this.f47995i.setAlpha(this.f47991e ? (int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f) : 255);
            this.f47995i.setStyle(Paint.Style.FILL);
            this.f47995i.setTextAlign(Paint.Align.CENTER);
            Paint.FontMetrics fontMetrics = this.f47995i.getFontMetrics();
            float height = ((int) ((getHeight() - fontMetrics.top) - fontMetrics.bottom)) >> 1;
            canvas.drawText(this.f47992f, getWidth() >> 1, height, this.f47995i);
            canvas.restore();
            canvas.save();
            canvas.clipRect(0, 0, width, getHeight());
            this.f47995i.setColor(this.m);
            this.f47995i.setAlpha((int) (this.f47991e ? SkinManager.RESOURCE_ALPHA_PRESS * 255.0f : 255.0f));
            this.f47995i.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.f47995i);
            this.f47995i.setColor(this.l);
            this.f47995i.setAlpha(this.f47991e ? (int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f) : 255);
            this.f47995i.setStyle(Paint.Style.FILL);
            this.f47995i.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.f47992f, getWidth() >> 1, height, this.f47995i);
            canvas.restore();
            if (this.f47994h == 0 || this.I) {
                return;
            }
            this.f47995i.setColor(this.l);
            this.f47995i.setAlpha(this.f47991e ? (int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f) : 255);
            this.f47995i.setStyle(Paint.Style.FILL);
            this.f47995i.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.f47992f, getWidth() >> 1, height, this.f47995i);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f47994h = TbadkCoreApplication.getInst().getSkinType();
            this.n = SkinManager.getColor(R.color.CAM_X0209);
            int i2 = this.f47994h;
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
            this.f47996j = SkinManager.getColor(R.color.CAM_X0304);
            this.m = SkinManager.getColor(R.color.CAM_X0303);
            this.l = SkinManager.getColor(R.color.CAM_X0101);
            this.w = SkinManager.getColor(R.color.CAM_X0201);
            int i4 = this.v;
            if (i4 != 0) {
                this.f47996j = i4;
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f47991e = true;
                postInvalidate();
            } else if (action == 1 || action == 3) {
                this.f47991e = false;
                postInvalidate();
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            e eVar = this.F;
            if (eVar != null) {
                eVar.onClick(this.z);
            }
            switch (this.z) {
                case 1:
                case 2:
                    c.a.r0.j0.b.b bVar = new c.a.r0.j0.b.b();
                    bVar.f19309e = this.A;
                    bVar.f19310f = 1;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921627, bVar));
                    l();
                    return;
                case 3:
                    c.a.q0.e0.a.i(this.B);
                    return;
                case 4:
                    c.a.q0.e0.a.a(this.B);
                    return;
                case 5:
                    l();
                    return;
                case 6:
                    c.a.q0.s.f0.p.d.b.a(this.B, 1000);
                    c.a.q0.e0.a.k(this.A.pkgName);
                    return;
                default:
                    return;
            }
        }
    }

    public final boolean q(@NonNull DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, downloadData)) == null) {
            int c2 = c.a.q0.e0.a.c(downloadData);
            int h2 = c.a.q0.e0.a.h(downloadData);
            this.f47993g = h2;
            if (c2 != 5 && c2 != 1) {
                if ((h2 <= 0 || h2 > 100) && !(this.f47993g == 0 && c2 == 7)) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, downloadData)) == null) {
            if (c.a.q0.e0.a.b(downloadData.getId())) {
                this.z = 3;
                this.f47993g = 100;
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean s(@NonNull ItemData itemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, itemData)) == null) {
            PackageInfo e2 = c.a.q0.e0.a.e(itemData.pkgName);
            if (e2 == null || e2.versionCode < itemData.apkDetail.version_code.intValue()) {
                return false;
            }
            this.z = 6;
            this.f47993g = 100;
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setClickCallback(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, eVar) == null) {
            this.F = eVar;
        }
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            this.E = onClickListener;
        }
    }

    public void setCustomColorBtn(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            if (i2 == Integer.MAX_VALUE) {
                int i3 = this.f47994h;
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
        if (interceptable == null || interceptable.invokeLIL(1048595, this, itemData, i2, str) == null) {
            this.A = itemData;
            this.C = str;
            if (!ItemCardHelper.w(itemData)) {
                this.z = 0;
                this.f47993g = this.v != 0 ? 100 : 0;
                this.B = null;
            } else {
                DownloadData j2 = c.a.q0.e0.a.j(itemData);
                this.B = j2;
                if (j2.getExtra() instanceof ItemDownloadExtraData) {
                    ((ItemDownloadExtraData) this.B.getExtra()).updateSceneCategory(i2);
                }
                if (!s(itemData) && !t(itemData) && !r(this.B) && !q(this.B)) {
                    this.z = 1;
                    this.f47993g = this.v != 0 ? 100 : 0;
                }
            }
            w();
            onChangeSkinType();
            c.a.q0.s.f0.p.d.b.a(this.B, 100);
        }
    }

    public void setShadow(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            String[] F = c.a.q0.s.u.a.F(i2);
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
        if (interceptable == null || interceptable.invokeL(1048597, this, bdUniqueId) == null) {
            this.H = bdUniqueId;
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.D = str;
            w();
        }
    }

    public void setUserProgressTextGradientModel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.I = z;
        }
    }

    public final boolean t(@NonNull ItemData itemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, itemData)) == null) {
            PackageInfo e2 = c.a.q0.e0.a.e(itemData.pkgName);
            if (e2 == null || e2.versionCode >= itemData.apkDetail.version_code.intValue()) {
                return false;
            }
            this.z = 2;
            this.f47993g = this.v != 0 ? 100 : 0;
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void u(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, context) == null) {
            Paint paint = new Paint(1);
            this.f47995i = paint;
            paint.setTextSize(l.g(getContext(), R.dimen.T_X08));
            this.k = l.g(getContext(), R.dimen.L_X01);
            onChangeSkinType();
            setOnClickListener(new c(this));
            if (context instanceof g) {
                g gVar = (g) context;
                gVar.getPageContext().registerListener(this.J);
                gVar.getPageContext().registerListener(this.K);
            }
        }
    }

    public void useLongText() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.y = true;
        }
    }

    public void useOpenSpecialView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.x = true;
            postInvalidate();
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (!s(this.A) && !t(this.A) && !r(this.B) && !q(this.B)) {
                this.z = 1;
                this.f47993g = this.v == 0 ? 0 : 100;
            }
            w();
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            int i2 = this.z;
            if (i2 == 0) {
                this.f47992f = TextUtils.isEmpty(this.D) ? this.A.buttonName : this.D;
            } else if (i2 == 2) {
                this.f47992f = getResources().getString(R.string.item_download_update);
            } else if (i2 == 3) {
                this.f47992f = getResources().getString(R.string.item_download_install);
            } else if (i2 == 4) {
                this.f47992f = String.format(getResources().getString(R.string.item_download_progress), Integer.valueOf(this.f47993g));
            } else if (i2 != 5) {
                if (i2 != 6) {
                    this.f47992f = this.A.buttonName;
                } else {
                    this.f47992f = getResources().getString(R.string.item_download_open);
                }
            } else if (!this.y) {
                this.f47992f = getResources().getString(R.string.item_download_pause);
            } else {
                this.f47992f = getResources().getString(R.string.go_on_download);
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
        this.f47994h = 0;
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
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.v = i2;
            if (z) {
                if (i2 == 0) {
                    this.f47995i.setTextSize(l.g(getContext(), R.dimen.T_X08));
                } else {
                    this.f47995i.setTextSize(l.g(getContext(), R.dimen.T_X07));
                }
            }
            onChangeSkinType();
        }
    }
}
