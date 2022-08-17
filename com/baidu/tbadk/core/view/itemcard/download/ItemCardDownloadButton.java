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
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.DownloadManagerActivityConfig;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
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
import com.repackage.aw4;
import com.repackage.b56;
import com.repackage.bw4;
import com.repackage.e9;
import com.repackage.ks4;
import com.repackage.qi;
import com.repackage.ru4;
import com.repackage.y55;
import java.util.List;
/* loaded from: classes3.dex */
public class ItemCardDownloadButton extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener A;
    public e B;
    public PermissionJudgePolicy C;
    public BdUniqueId D;
    public boolean E;
    public final CustomMessageListener F;
    public final CustomMessageListener G;
    public boolean a;
    public String b;
    public int c;
    public int d;
    public Paint e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public boolean t;
    public boolean u;
    public int v;
    public ItemData w;
    public DownloadData x;
    public String y;
    public String z;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ItemCardDownloadButton a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ItemCardDownloadButton itemCardDownloadButton, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemCardDownloadButton, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.x != null && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage)) {
                List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                if (ListUtils.isEmpty(data)) {
                    return;
                }
                for (DownloadData downloadData : data) {
                    if (this.a.x.getId().equals(downloadData.getId())) {
                        int status = downloadData.getStatus();
                        if (status == 1) {
                            this.a.c = downloadData.getProcess();
                            this.a.v = 4;
                        } else if (status == 2 || status == 4) {
                            this.a.c = downloadData.getProcess();
                            this.a.x.setStatus(7);
                            this.a.v = 5;
                        } else if (status != 5) {
                            this.a.w();
                        } else {
                            ItemCardDownloadButton itemCardDownloadButton = this.a;
                            itemCardDownloadButton.c = y55.h(itemCardDownloadButton.x);
                            this.a.v = 4;
                        }
                        this.a.x();
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ItemCardDownloadButton a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ItemCardDownloadButton itemCardDownloadButton, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemCardDownloadButton, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.x == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Intent) {
                if (this.a.w.pkgName.equals(y55.g((Intent) data))) {
                    this.a.w();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ItemCardDownloadButton a;

        public c(ItemCardDownloadButton itemCardDownloadButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemCardDownloadButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = itemCardDownloadButton;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.v == 0) {
                    if (this.a.A != null) {
                        this.a.A.onClick(view2);
                        return;
                    }
                    return;
                }
                this.a.p();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements PermissionJudgePolicy.OnPermissionsGrantedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ItemCardDownloadButton a;

        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ d b;

            public a(d dVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = dVar;
                this.a = str;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    ItemCardHelper.g(2, this.a, this.b.a.w.itemId);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new DownloadManagerActivityConfig(this.b.a.getContext(), 3)));
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.x == null) {
                return;
            }
            if (this.a.v == 2 || this.a.v == 1) {
                String simpleName = ((Activity) this.a.getContext()).getClass().getSimpleName();
                if (!"DownloadManagerActivity".equals(simpleName) && ru4.k().h("key_download_manager_first_toast", true)) {
                    ru4.k().u("key_download_manager_first_toast", false);
                    ItemCardHelper.g(1, simpleName, this.a.w.itemId);
                    ScreenTopToast screenTopToast = new ScreenTopToast(this.a.getContext());
                    screenTopToast.m(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0991));
                    screenTopToast.k(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f04eb));
                    screenTopToast.j(new a(this, simpleName));
                    screenTopToast.n((ViewGroup) ((Activity) this.a.getContext()).findViewById(16908290));
                }
            }
            if (!(this.a.x.getExtra() instanceof ItemDownloadExtraData) || !((ItemDownloadExtraData) this.a.x.getExtra()).isShouzhuData()) {
                y55.l(this.a.x);
            } else if (this.a.v == 5) {
                bw4.a(this.a.x, 500);
                aw4.f().d(this.a.w, this.a.x, this.a.y, this.a.D);
            } else {
                bw4.a(this.a.x, 200);
                aw4.f().e(this.a.w, this.a.x, this.a.y, this.a.D);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface e {
        void onClick(int i);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.u = true;
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.t = true;
            postInvalidate();
        }
    }

    public ItemData getCurrentItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.w : (ItemData) invokeV.objValue;
    }

    public int getObjTypeByDownloadMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            switch (this.v) {
                case 1:
                    if (ItemCardHelper.b.equals(this.w.buttonName)) {
                        return 2;
                    }
                    return ItemCardHelper.c.equals(this.w.buttonName) ? 10 : -1;
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
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.C == null) {
                PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
                this.C = permissionJudgePolicy;
                permissionJudgePolicy.setOnPermissionsGrantedListener(new d(this));
            }
            if (getContext() instanceof Activity) {
                this.C.clearRequestPermissionList();
                this.C.appendRequestPermission((Activity) getContext(), "android.permission.WRITE_EXTERNAL_STORAGE");
                this.C.startRequestPermission((Activity) getContext());
            }
        }
    }

    public final void m(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, canvas) == null) {
            this.e.setColor(this.f);
            this.e.setAlpha((int) ((this.a ? SkinManager.RESOURCE_ALPHA_PRESS * 255.0f : 255.0f) * 0.5f));
            this.e.setStyle(Paint.Style.STROKE);
            this.e.setStrokeWidth(this.g);
            this.e.setShadowLayer(this.q, this.o, this.p, this.n);
            canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.e);
            this.e.clearShadowLayer();
            this.e.setColor(this.f);
            this.e.setAlpha(this.a ? (int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f) : 255);
            this.e.setStyle(Paint.Style.FILL);
            this.e.setTextAlign(Paint.Align.CENTER);
            Paint.FontMetrics fontMetrics = this.e.getFontMetrics();
            canvas.drawText(this.b, getWidth() >> 1, ((int) ((getHeight() - fontMetrics.top) - fontMetrics.bottom)) >> 1, this.e);
        }
    }

    public final void n(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, canvas) == null) {
            if (this.r != 0) {
                this.e.setColor(this.s);
                this.e.setAlpha(255);
                this.e.setStyle(Paint.Style.FILL_AND_STROKE);
                this.e.setShadowLayer(this.q, this.o, this.p, this.n);
                canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.e);
                this.e.clearShadowLayer();
            }
            int i = this.d;
            if (i != 1 && i != 4) {
                this.e.setAlpha((int) ((this.a ? SkinManager.RESOURCE_ALPHA_PRESS * 255.0f : 255.0f) * 0.25f));
            } else {
                this.e.setAlpha((int) ((this.a ? SkinManager.RESOURCE_ALPHA_PRESS * 255.0f : 255.0f) * 0.5f));
            }
            this.e.setColor(this.k);
            this.e.setStyle(Paint.Style.STROKE);
            this.e.setStrokeWidth(this.g);
            this.e.setShadowLayer(this.q, this.o, this.p, this.n);
            canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.e);
            this.e.clearShadowLayer();
            this.e.setColor(this.j);
            this.e.setAlpha((int) ((this.a ? SkinManager.RESOURCE_ALPHA_PRESS * 255.0f : 255.0f) * 0.5f));
            this.e.setStyle(Paint.Style.FILL);
            this.e.setStrokeWidth(this.g);
            this.e.setShadowLayer(this.q, this.o, this.p, this.n);
            canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.e);
            this.e.clearShadowLayer();
            this.e.setColor(this.l);
            this.e.setAlpha(this.a ? (int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f) : 255);
            this.e.setStyle(Paint.Style.FILL);
            this.e.setTextAlign(Paint.Align.CENTER);
            Paint.FontMetrics fontMetrics = this.e.getFontMetrics();
            canvas.drawText(this.b, getWidth() >> 1, ((int) ((getHeight() - fontMetrics.top) - fontMetrics.bottom)) >> 1, this.e);
        }
    }

    public final void o(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, canvas) == null) {
            if (this.r != 0) {
                this.e.setColor(this.s);
                this.e.setAlpha(255);
                this.e.setStyle(Paint.Style.FILL_AND_STROKE);
                this.e.setShadowLayer(this.q, this.o, this.p, this.n);
                canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.e);
                this.e.clearShadowLayer();
            }
            int width = (getWidth() * this.c) / 100;
            canvas.save();
            canvas.clipRect(width, 0, getWidth(), getHeight());
            this.e.setColor(this.i);
            this.e.setAlpha((int) ((this.a ? SkinManager.RESOURCE_ALPHA_PRESS * 255.0f : 255.0f) * 0.08f));
            this.e.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.e);
            this.e.setColor(this.i);
            this.e.setAlpha(this.a ? (int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f) : 255);
            this.e.setStyle(Paint.Style.FILL);
            this.e.setTextAlign(Paint.Align.CENTER);
            Paint.FontMetrics fontMetrics = this.e.getFontMetrics();
            float height = ((int) ((getHeight() - fontMetrics.top) - fontMetrics.bottom)) >> 1;
            canvas.drawText(this.b, getWidth() >> 1, height, this.e);
            canvas.restore();
            canvas.save();
            canvas.clipRect(0, 0, width, getHeight());
            this.e.setColor(this.i);
            this.e.setAlpha((int) (this.a ? SkinManager.RESOURCE_ALPHA_PRESS * 255.0f : 255.0f));
            this.e.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.e);
            this.e.setColor(this.h);
            this.e.setAlpha(this.a ? (int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f) : 255);
            this.e.setStyle(Paint.Style.FILL);
            this.e.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.b, getWidth() >> 1, height, this.e);
            canvas.restore();
            if (this.d == 0 || this.E) {
                return;
            }
            this.e.setColor(this.h);
            this.e.setAlpha(this.a ? (int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f) : 255);
            this.e.setStyle(Paint.Style.FILL);
            this.e.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.b, getWidth() >> 1, height, this.e);
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onAttachedToWindow();
            y();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDetachedFromWindow();
            z();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.w == null) {
                return;
            }
            if (this.v == 6 && this.t) {
                n(canvas);
                return;
            }
            int i = this.v;
            if ((i == 0 || i == 1 || i == 2 || i == 6) && this.r == 0) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.a = true;
                postInvalidate();
            } else if (action == 1 || action == 3) {
                this.a = false;
                postInvalidate();
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            e eVar = this.B;
            if (eVar != null) {
                eVar.onClick(this.v);
            }
            switch (this.v) {
                case 1:
                case 2:
                    b56 b56Var = new b56();
                    b56Var.a = this.w;
                    b56Var.b = 1;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921627, b56Var));
                    l();
                    return;
                case 3:
                    y55.i(this.x);
                    return;
                case 4:
                    y55.a(this.x);
                    return;
                case 5:
                    l();
                    return;
                case 6:
                    bw4.a(this.x, 1000);
                    y55.k(this.w.pkgName);
                    return;
                default:
                    return;
            }
        }
    }

    public final boolean q(@NonNull DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, downloadData)) == null) {
            int c2 = y55.c(downloadData);
            int h = y55.h(downloadData);
            this.c = h;
            if (c2 != 5 && c2 != 1) {
                if ((h <= 0 || h > 100) && !(this.c == 0 && c2 == 7)) {
                    return false;
                }
                this.v = 5;
                return true;
            }
            this.v = 4;
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean r(@NonNull DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, downloadData)) == null) {
            if (y55.b(downloadData.getId())) {
                this.v = 3;
                this.c = 100;
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean s(@NonNull ItemData itemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, itemData)) == null) {
            PackageInfo e2 = y55.e(itemData.pkgName);
            if (e2 == null || e2.versionCode < itemData.apkDetail.version_code.intValue()) {
                return false;
            }
            this.v = 6;
            this.c = 100;
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setClickCallback(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, eVar) == null) {
            this.B = eVar;
        }
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) {
            this.A = onClickListener;
        }
    }

    public void setCustomColorBtn(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            if (i == Integer.MAX_VALUE) {
                int i2 = this.d;
                if (i2 != 1 && i2 != 4) {
                    i = SkinManager.getColor(R.color.CAM_X0303);
                } else {
                    i = SkinManager.getColor(R.color.CAM_X0209);
                }
            }
            setCustomColorBtn(i, true);
        }
    }

    public void setData(@NonNull ItemData itemData, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048598, this, itemData, i, str) == null) {
            this.w = itemData;
            this.y = str;
            if (!ItemCardHelper.w(itemData)) {
                this.v = 0;
                this.c = this.r != 0 ? 100 : 0;
                this.x = null;
            } else {
                DownloadData j = y55.j(itemData);
                this.x = j;
                if (j.getExtra() instanceof ItemDownloadExtraData) {
                    ((ItemDownloadExtraData) this.x.getExtra()).updateSceneCategory(i);
                }
                if (!s(itemData) && !t(itemData) && !r(this.x) && !q(this.x)) {
                    this.v = 1;
                    this.c = this.r != 0 ? 100 : 0;
                }
            }
            x();
            v();
            bw4.a(this.x, 100);
        }
    }

    public void setShadow(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            String[] F = ks4.F(i);
            int identifier = TbadkCoreApplication.getInst().getResources().getIdentifier(F[0], "color", TbadkCoreApplication.getInst().getPackageName());
            this.m = identifier;
            this.n = SkinManager.getColor(identifier);
            Resources resources = TbadkCoreApplication.getInst().getResources();
            Resources resources2 = TbadkCoreApplication.getInst().getResources();
            this.q = resources.getDimensionPixelSize(resources2.getIdentifier("tbds" + F[1], EMABTest.TYPE_DIMEN, TbadkCoreApplication.getInst().getPackageName()));
            String[] split = F[2].split(",");
            Resources resources3 = TbadkCoreApplication.getInst().getResources();
            Resources resources4 = TbadkCoreApplication.getInst().getResources();
            this.o = resources3.getDimensionPixelSize(resources4.getIdentifier("tbds" + split[0], EMABTest.TYPE_DIMEN, TbadkCoreApplication.getInst().getPackageName()));
            Resources resources5 = TbadkCoreApplication.getInst().getResources();
            Resources resources6 = TbadkCoreApplication.getInst().getResources();
            this.p = resources5.getDimensionPixelSize(resources6.getIdentifier("tbds" + split[1], EMABTest.TYPE_DIMEN, TbadkCoreApplication.getInst().getPackageName()));
            postInvalidate();
        }
    }

    public void setTag(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bdUniqueId) == null) {
            this.D = bdUniqueId;
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.z = str;
            x();
        }
    }

    public void setUserProgressTextGradientModel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.E = z;
        }
    }

    public final boolean t(@NonNull ItemData itemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, itemData)) == null) {
            PackageInfo e2 = y55.e(itemData.pkgName);
            if (e2 == null || e2.versionCode >= itemData.apkDetail.version_code.intValue()) {
                return false;
            }
            this.v = 2;
            this.c = this.r != 0 ? 100 : 0;
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void u(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, context) == null) {
            Paint paint = new Paint(1);
            this.e = paint;
            paint.setTextSize(qi.f(getContext(), R.dimen.T_X08));
            this.g = qi.f(getContext(), R.dimen.L_X01);
            v();
            setOnClickListener(new c(this));
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.d = TbadkCoreApplication.getInst().getSkinType();
            this.j = SkinManager.getColor(R.color.CAM_X0209);
            int i = this.d;
            if (i != 1 && i != 4) {
                int i2 = this.r;
                if (i2 != 0) {
                    this.l = i2;
                    this.k = i2;
                } else {
                    this.l = SkinManager.getColor(R.color.CAM_X0304);
                    this.k = SkinManager.getColor(R.color.CAM_X0304);
                }
            } else {
                this.k = SkinManager.getColor(R.color.CAM_X0209);
                this.l = SkinManager.getColor(R.color.CAM_X0103);
            }
            this.n = SkinManager.getColor(this.m);
            this.f = SkinManager.getColor(R.color.CAM_X0304);
            this.i = SkinManager.getColor(R.color.CAM_X0303);
            this.h = SkinManager.getColor(R.color.CAM_X0101);
            this.s = SkinManager.getColor(R.color.CAM_X0201);
            int i3 = this.r;
            if (i3 != 0) {
                this.f = i3;
                this.i = i3;
            }
            postInvalidate();
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            if (!s(this.w) && !t(this.w) && !r(this.x) && !q(this.x)) {
                this.v = 1;
                this.c = this.r == 0 ? 0 : 100;
            }
            x();
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            int i = this.v;
            if (i == 0) {
                this.b = TextUtils.isEmpty(this.z) ? this.w.buttonName : this.z;
            } else if (i == 2) {
                this.b = getResources().getString(R.string.obfuscated_res_0x7f0f098e);
            } else if (i == 3) {
                this.b = getResources().getString(R.string.obfuscated_res_0x7f0f0987);
            } else if (i == 4) {
                this.b = String.format(getResources().getString(R.string.obfuscated_res_0x7f0f098c), Integer.valueOf(this.c));
            } else if (i != 5) {
                if (i != 6) {
                    this.b = this.w.buttonName;
                } else {
                    this.b = getResources().getString(R.string.obfuscated_res_0x7f0f0989);
                }
            } else if (!this.u) {
                this.b = getResources().getString(R.string.obfuscated_res_0x7f0f098a);
            } else {
                this.b = getResources().getString(R.string.obfuscated_res_0x7f0f07cf);
            }
            postInvalidate();
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && (getContext() instanceof e9)) {
            ((e9) getContext()).getPageContext().registerListener(this.F);
            ((e9) getContext()).getPageContext().registerListener(this.G);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.F);
            MessageManager.getInstance().unRegisterListener(this.G);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.D : (BdUniqueId) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemCardDownloadButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.d = 0;
        this.t = false;
        this.u = false;
        this.D = BdUniqueId.gen();
        this.E = false;
        this.F = new a(this, 2001118);
        this.G = new b(this, 2002504);
        u(context);
    }

    public void setCustomColorBtn(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.r = i;
            if (z) {
                if (i == 0) {
                    this.e.setTextSize(qi.f(getContext(), R.dimen.T_X08));
                } else {
                    this.e.setTextSize(qi.f(getContext(), R.dimen.T_X07));
                }
            }
            v();
        }
    }
}
