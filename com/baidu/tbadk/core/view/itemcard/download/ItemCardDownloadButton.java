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
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.e.a.g;
import c.a.e.e.p.l;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.R;
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
    public String A;
    public String B;
    public View.OnClickListener C;
    public e D;
    public PermissionJudgePolicy E;
    public BdUniqueId F;
    public final CustomMessageListener G;
    public final CustomMessageListener H;

    /* renamed from: e  reason: collision with root package name */
    public boolean f47838e;

    /* renamed from: f  reason: collision with root package name */
    public String f47839f;

    /* renamed from: g  reason: collision with root package name */
    public int f47840g;

    /* renamed from: h  reason: collision with root package name */
    public int f47841h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f47842i;

    /* renamed from: j  reason: collision with root package name */
    public int f47843j;
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
    public int x;
    public Item y;
    public DownloadData z;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ItemCardDownloadButton f47844a;

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
            this.f47844a = itemCardDownloadButton;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.f47844a.z != null && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage)) {
                List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                if (ListUtils.isEmpty(data)) {
                    return;
                }
                for (DownloadData downloadData : data) {
                    if (this.f47844a.z.getId().equals(downloadData.getId())) {
                        int status = downloadData.getStatus();
                        if (status == 1) {
                            this.f47844a.f47840g = downloadData.getProcess();
                            this.f47844a.x = 4;
                        } else if (status == 2 || status == 4) {
                            this.f47844a.f47840g = downloadData.getProcess();
                            this.f47844a.z.setStatus(7);
                            this.f47844a.x = 5;
                        } else if (status != 5) {
                            this.f47844a.v();
                        } else {
                            ItemCardDownloadButton itemCardDownloadButton = this.f47844a;
                            itemCardDownloadButton.f47840g = c.a.p0.d0.a.g(itemCardDownloadButton.z);
                            this.f47844a.x = 4;
                        }
                        this.f47844a.w();
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
        public final /* synthetic */ ItemCardDownloadButton f47845a;

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
            this.f47845a = itemCardDownloadButton;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f47845a.z == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Intent) {
                if (this.f47845a.y.apk_name.equals(c.a.p0.d0.a.f((Intent) data))) {
                    this.f47845a.v();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ItemCardDownloadButton f47846e;

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
            this.f47846e = itemCardDownloadButton;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f47846e.x == 0) {
                    if (this.f47846e.C != null) {
                        this.f47846e.C.onClick(view);
                        return;
                    }
                    return;
                }
                this.f47846e.p();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements PermissionJudgePolicy.OnPermissionsGrantedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ItemCardDownloadButton f47847a;

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
            this.f47847a = itemCardDownloadButton;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f47847a.z == null) {
                return;
            }
            if (!(this.f47847a.z.getExtra() instanceof ItemDownloadExtraData) || !((ItemDownloadExtraData) this.f47847a.z.getExtra()).isShouzhuData()) {
                c.a.p0.d0.a.k(this.f47847a.z);
            } else if (this.f47847a.x == 5) {
                c.a.p0.s.f0.p.d.b.a(this.f47847a.z, 500);
                c.a.p0.s.f0.p.d.a.f().d(this.f47847a.y, this.f47847a.z, this.f47847a.A, this.f47847a.F);
            } else {
                c.a.p0.s.f0.p.d.b.a(this.f47847a.z, 200);
                c.a.p0.s.f0.p.d.a.f().e(this.f47847a.y, this.f47847a.z, this.f47847a.A, this.f47847a.F);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.y : (Item) invokeV.objValue;
    }

    public int getObjTypeByDownloadMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            switch (this.x) {
                case 1:
                    if (ItemCardHelper.f47829b.equals(this.y.button_name)) {
                        return 2;
                    }
                    return ItemCardHelper.f47830c.equals(this.y.button_name) ? 10 : -1;
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
            if (this.E == null) {
                PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
                this.E = permissionJudgePolicy;
                permissionJudgePolicy.setOnPermissionsGrantedListener(new d(this));
            }
            if (getContext() instanceof Activity) {
                this.E.clearRequestPermissionList();
                this.E.appendRequestPermission((Activity) getContext(), "android.permission.WRITE_EXTERNAL_STORAGE");
                this.E.startRequestPermission((Activity) getContext());
            }
        }
    }

    public final void m(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            this.f47842i.setColor(this.f47843j);
            this.f47842i.setAlpha((int) ((this.f47838e ? SkinManager.RESOURCE_ALPHA_PRESS * 255.0f : 255.0f) * 0.5f));
            this.f47842i.setStyle(Paint.Style.STROKE);
            this.f47842i.setStrokeWidth(this.k);
            this.f47842i.setShadowLayer(this.u, this.s, this.t, this.r);
            canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.f47842i);
            this.f47842i.clearShadowLayer();
            this.f47842i.setColor(this.f47843j);
            this.f47842i.setAlpha(this.f47838e ? (int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f) : 255);
            this.f47842i.setStyle(Paint.Style.FILL);
            this.f47842i.setTextAlign(Paint.Align.CENTER);
            Paint.FontMetrics fontMetrics = this.f47842i.getFontMetrics();
            canvas.drawText(this.f47839f, getWidth() >> 1, ((int) ((getHeight() - fontMetrics.top) - fontMetrics.bottom)) >> 1, this.f47842i);
        }
    }

    public final void n(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, canvas) == null) {
            if (this.v != 0) {
                this.f47842i.setColor(this.w);
                this.f47842i.setAlpha(255);
                this.f47842i.setStyle(Paint.Style.FILL_AND_STROKE);
                this.f47842i.setShadowLayer(this.u, this.s, this.t, this.r);
                canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.f47842i);
                this.f47842i.clearShadowLayer();
            }
            int i2 = this.f47841h;
            if (i2 != 1 && i2 != 4) {
                this.f47842i.setAlpha((int) ((this.f47838e ? SkinManager.RESOURCE_ALPHA_PRESS * 255.0f : 255.0f) * 0.25f));
            } else {
                this.f47842i.setAlpha((int) ((this.f47838e ? SkinManager.RESOURCE_ALPHA_PRESS * 255.0f : 255.0f) * 0.5f));
            }
            this.f47842i.setColor(this.o);
            this.f47842i.setStyle(Paint.Style.STROKE);
            this.f47842i.setStrokeWidth(this.k);
            this.f47842i.setShadowLayer(this.u, this.s, this.t, this.r);
            canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.f47842i);
            this.f47842i.clearShadowLayer();
            this.f47842i.setColor(this.n);
            this.f47842i.setAlpha((int) ((this.f47838e ? SkinManager.RESOURCE_ALPHA_PRESS * 255.0f : 255.0f) * 0.5f));
            this.f47842i.setStyle(Paint.Style.FILL);
            this.f47842i.setStrokeWidth(this.k);
            this.f47842i.setShadowLayer(this.u, this.s, this.t, this.r);
            canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.f47842i);
            this.f47842i.clearShadowLayer();
            this.f47842i.setColor(this.p);
            this.f47842i.setAlpha(this.f47838e ? (int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f) : 255);
            this.f47842i.setStyle(Paint.Style.FILL);
            this.f47842i.setTextAlign(Paint.Align.CENTER);
            Paint.FontMetrics fontMetrics = this.f47842i.getFontMetrics();
            canvas.drawText(this.f47839f, getWidth() >> 1, ((int) ((getHeight() - fontMetrics.top) - fontMetrics.bottom)) >> 1, this.f47842i);
        }
    }

    public final void o(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, canvas) == null) {
            if (this.v != 0) {
                this.f47842i.setColor(this.w);
                this.f47842i.setAlpha(255);
                this.f47842i.setStyle(Paint.Style.FILL_AND_STROKE);
                this.f47842i.setShadowLayer(this.u, this.s, this.t, this.r);
                canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.f47842i);
                this.f47842i.clearShadowLayer();
            }
            int width = (getWidth() * this.f47840g) / 100;
            canvas.save();
            canvas.clipRect(width, 0, getWidth(), getHeight());
            this.f47842i.setColor(this.m);
            this.f47842i.setAlpha((int) ((this.f47838e ? SkinManager.RESOURCE_ALPHA_PRESS * 255.0f : 255.0f) * 0.08f));
            this.f47842i.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.f47842i);
            this.f47842i.setColor(this.m);
            this.f47842i.setAlpha(this.f47838e ? (int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f) : 255);
            this.f47842i.setStyle(Paint.Style.FILL);
            this.f47842i.setTextAlign(Paint.Align.CENTER);
            Paint.FontMetrics fontMetrics = this.f47842i.getFontMetrics();
            float height = ((int) ((getHeight() - fontMetrics.top) - fontMetrics.bottom)) >> 1;
            canvas.drawText(this.f47839f, getWidth() >> 1, height, this.f47842i);
            canvas.restore();
            canvas.save();
            canvas.clipRect(0, 0, width, getHeight());
            this.f47842i.setColor(this.m);
            this.f47842i.setAlpha((int) (this.f47838e ? SkinManager.RESOURCE_ALPHA_PRESS * 255.0f : 255.0f));
            this.f47842i.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.f47842i);
            this.f47842i.setColor(this.l);
            this.f47842i.setAlpha(this.f47838e ? (int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f) : 255);
            this.f47842i.setStyle(Paint.Style.FILL);
            this.f47842i.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.f47839f, getWidth() >> 1, height, this.f47842i);
            canvas.restore();
            if (this.f47841h != 0) {
                this.f47842i.setColor(this.l);
                this.f47842i.setAlpha(this.f47838e ? (int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f) : 255);
                this.f47842i.setStyle(Paint.Style.FILL);
                this.f47842i.setTextAlign(Paint.Align.CENTER);
                canvas.drawText(this.f47839f, getWidth() >> 1, height, this.f47842i);
            }
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f47841h = TbadkCoreApplication.getInst().getSkinType();
            this.n = SkinManager.getColor(R.color.CAM_X0209);
            int i2 = this.f47841h;
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
            this.f47843j = SkinManager.getColor(R.color.CAM_X0304);
            this.m = SkinManager.getColor(R.color.CAM_X0303);
            this.l = SkinManager.getColor(R.color.CAM_X0101);
            this.w = SkinManager.getColor(R.color.CAM_X0201);
            int i4 = this.v;
            if (i4 != 0) {
                this.f47843j = i4;
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
            if (this.y == null) {
                return;
            }
            this.f47842i.setColor(0);
            this.f47842i.setAlpha(0);
            canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.f47842i);
            this.f47842i.clearShadowLayer();
            int i2 = this.x;
            if ((i2 == 0 || i2 == 1 || i2 == 2) && this.v == 0) {
                m(canvas);
            } else if (this.x == 6) {
                n(canvas);
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
                this.f47838e = true;
                postInvalidate();
            } else if (action == 1 || action == 3) {
                this.f47838e = false;
                postInvalidate();
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            e eVar = this.D;
            if (eVar != null) {
                eVar.onClick(this.x);
            }
            switch (this.x) {
                case 1:
                case 2:
                case 5:
                    l();
                    return;
                case 3:
                    c.a.p0.d0.a.h(this.z);
                    return;
                case 4:
                    c.a.p0.d0.a.a(this.z);
                    return;
                case 6:
                    c.a.p0.s.f0.p.d.b.a(this.z, 1000);
                    c.a.p0.d0.a.j(this.y.apk_name);
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
            int c2 = c.a.p0.d0.a.c(downloadData);
            int g2 = c.a.p0.d0.a.g(downloadData);
            this.f47840g = g2;
            if (c2 == 5 || c2 == 1) {
                this.x = 4;
                return true;
            } else if (g2 <= 0 || g2 > 100) {
                return false;
            } else {
                this.x = 5;
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final boolean r(@NonNull DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, downloadData)) == null) {
            if (c.a.p0.d0.a.b(downloadData.getId())) {
                this.x = 3;
                this.f47840g = 100;
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
            PackageInfo d2 = c.a.p0.d0.a.d(item.apk_name);
            if (d2 == null || d2.versionCode < item.apk_detail.version_code.intValue()) {
                return false;
            }
            this.x = 6;
            this.f47840g = 100;
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setClickCallback(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, eVar) == null) {
            this.D = eVar;
        }
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            this.C = onClickListener;
        }
    }

    public void setCustomColorBtn(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.v = i2;
            if (i2 == 0) {
                this.f47842i.setTextSize(l.g(getContext(), R.dimen.T_X08));
            } else {
                this.f47842i.setTextSize(l.g(getContext(), R.dimen.T_X07));
            }
            postInvalidate();
        }
    }

    public void setData(@NonNull Item item, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048594, this, item, i2, str) == null) {
            this.y = item;
            this.A = str;
            if (!ItemCardHelper.t(item)) {
                this.x = 0;
                this.f47840g = this.v != 0 ? 100 : 0;
                this.z = null;
            } else {
                DownloadData i3 = c.a.p0.d0.a.i(item);
                this.z = i3;
                if (i3.getExtra() instanceof ItemDownloadExtraData) {
                    ((ItemDownloadExtraData) this.z.getExtra()).updateSceneCategory(i2);
                }
                if (!s(item) && !t(item) && !r(this.z) && !q(this.z)) {
                    this.x = 1;
                    this.f47840g = this.v != 0 ? 100 : 0;
                }
            }
            w();
            onChangeSkinType();
            c.a.p0.s.f0.p.d.b.a(this.z, 100);
        }
    }

    public void setShadow(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            String[] F = c.a.p0.s.u.a.F(i2);
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
        if (interceptable == null || interceptable.invokeL(1048596, this, bdUniqueId) == null) {
            this.F = bdUniqueId;
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.B = str;
            w();
        }
    }

    public final boolean t(@NonNull Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, item)) == null) {
            PackageInfo d2 = c.a.p0.d0.a.d(item.apk_name);
            if (d2 == null || d2.versionCode >= item.apk_detail.version_code.intValue()) {
                return false;
            }
            this.x = 2;
            this.f47840g = this.v != 0 ? 100 : 0;
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void u(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, context) == null) {
            Paint paint = new Paint(1);
            this.f47842i = paint;
            paint.setTextSize(l.g(getContext(), R.dimen.T_X08));
            this.k = l.g(getContext(), R.dimen.L_X01);
            onChangeSkinType();
            setOnClickListener(new c(this));
            if (context instanceof g) {
                g gVar = (g) context;
                gVar.getPageContext().registerListener(this.G);
                gVar.getPageContext().registerListener(this.H);
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if (!s(this.y) && !t(this.y) && !r(this.z) && !q(this.z)) {
                this.x = 1;
                this.f47840g = this.v == 0 ? 0 : 100;
            }
            w();
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            int i2 = this.x;
            if (i2 == 0) {
                this.f47839f = TextUtils.isEmpty(this.B) ? this.y.button_name : this.B;
            } else if (i2 == 2) {
                this.f47839f = getResources().getString(R.string.item_download_update);
            } else if (i2 == 3) {
                this.f47839f = getResources().getString(R.string.item_download_install);
            } else if (i2 == 4) {
                this.f47839f = String.format(getResources().getString(R.string.item_download_progress), Integer.valueOf(this.f47840g));
            } else if (i2 != 5) {
                if (i2 != 6) {
                    this.f47839f = this.y.button_name;
                } else {
                    this.f47839f = getResources().getString(R.string.item_download_open);
                }
            } else if (this.v == 0) {
                this.f47839f = getResources().getString(R.string.item_download_pause);
            } else {
                this.f47839f = getResources().getString(R.string.go_on_download);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.F : (BdUniqueId) invokeV.objValue;
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
        this.f47841h = 0;
        this.F = BdUniqueId.gen();
        this.G = new a(this, 2001118);
        this.H = new b(this, 2002504);
        u(context);
    }
}
