package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
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
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.d.a.g;
import d.a.d.e.p.l;
import java.util.List;
import tbclient.Item;
/* loaded from: classes3.dex */
public class ItemCardDownloadButton extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f12468e;

    /* renamed from: f  reason: collision with root package name */
    public String f12469f;

    /* renamed from: g  reason: collision with root package name */
    public int f12470g;

    /* renamed from: h  reason: collision with root package name */
    public int f12471h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f12472i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public Item q;
    public DownloadData r;
    public String s;
    public View.OnClickListener t;
    public e u;
    public PermissionJudgePolicy v;
    public final CustomMessageListener w;
    public final CustomMessageListener x;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ItemCardDownloadButton f12473a;

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
            this.f12473a = itemCardDownloadButton;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.f12473a.r != null && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage)) {
                List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                if (ListUtils.isEmpty(data)) {
                    return;
                }
                for (DownloadData downloadData : data) {
                    if (this.f12473a.r.getId().equals(downloadData.getId())) {
                        int status = downloadData.getStatus();
                        if (status == 1) {
                            this.f12473a.f12470g = downloadData.getProcess();
                            this.f12473a.p = 4;
                        } else if (status == 2 || status == 4) {
                            this.f12473a.f12470g = downloadData.getProcess();
                            this.f12473a.r.setStatus(7);
                            this.f12473a.p = 5;
                        } else if (status != 5) {
                            this.f12473a.t();
                        } else {
                            ItemCardDownloadButton itemCardDownloadButton = this.f12473a;
                            itemCardDownloadButton.f12470g = d.a.p0.d0.a.g(itemCardDownloadButton.r);
                            this.f12473a.p = 4;
                        }
                        this.f12473a.u();
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

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ItemCardDownloadButton f12474a;

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
            this.f12474a = itemCardDownloadButton;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f12474a.r == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Intent) {
                if (this.f12474a.q.apk_name.equals(d.a.p0.d0.a.f((Intent) data))) {
                    this.f12474a.t();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ItemCardDownloadButton f12475e;

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
            this.f12475e = itemCardDownloadButton;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f12475e.p == 0) {
                    if (this.f12475e.t != null) {
                        this.f12475e.t.onClick(view);
                        return;
                    }
                    return;
                }
                this.f12475e.m();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements PermissionJudgePolicy.OnPermissionsGrantedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ItemCardDownloadButton f12476a;

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
            this.f12476a = itemCardDownloadButton;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.p0.d0.a.k(this.f12476a.r);
            }
        }
    }

    /* loaded from: classes3.dex */
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

    public int getObjTypeByDownloadMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = this.p;
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        return i2 != 6 ? -1 : 5;
                    }
                    return 2;
                }
                return 4;
            }
            return 6;
        }
        return invokeV.intValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.v == null) {
                PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
                this.v = permissionJudgePolicy;
                permissionJudgePolicy.setOnPermissionsGrantedListener(new d(this));
            }
            if (getContext() instanceof Activity) {
                this.v.clearRequestPermissionList();
                this.v.appendRequestPermission((Activity) getContext(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                this.v.startRequestPermission((Activity) getContext());
            }
        }
    }

    public final void k(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            this.f12472i.setColor(this.j);
            this.f12472i.setAlpha((int) ((this.f12468e ? SkinManager.RESOURCE_ALPHA_PRESS * 255.0f : 255.0f) * 0.5f));
            this.f12472i.setStyle(Paint.Style.STROKE);
            this.f12472i.setStrokeWidth(this.k);
            canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.f12472i);
            this.f12472i.setColor(this.j);
            this.f12472i.setAlpha(this.f12468e ? (int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f) : 255);
            this.f12472i.setStyle(Paint.Style.FILL);
            this.f12472i.setTextAlign(Paint.Align.CENTER);
            Paint.FontMetrics fontMetrics = this.f12472i.getFontMetrics();
            canvas.drawText(this.f12469f, getWidth() >> 1, ((int) ((getHeight() - fontMetrics.top) - fontMetrics.bottom)) >> 1, this.f12472i);
        }
    }

    public final void l(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            if (this.n != 0) {
                this.f12472i.setColor(this.o);
                this.f12472i.setAlpha(255);
                this.f12472i.setStyle(Paint.Style.FILL_AND_STROKE);
                canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.f12472i);
            }
            int width = (getWidth() * this.f12470g) / 100;
            canvas.save();
            canvas.clipRect(width, 0, getWidth(), getHeight());
            this.f12472i.setColor(this.m);
            this.f12472i.setAlpha((int) ((this.f12468e ? SkinManager.RESOURCE_ALPHA_PRESS * 255.0f : 255.0f) * 0.08f));
            this.f12472i.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.f12472i);
            this.f12472i.setColor(this.m);
            this.f12472i.setAlpha(this.f12468e ? (int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f) : 255);
            this.f12472i.setStyle(Paint.Style.FILL);
            this.f12472i.setTextAlign(Paint.Align.CENTER);
            Paint.FontMetrics fontMetrics = this.f12472i.getFontMetrics();
            float height = ((int) ((getHeight() - fontMetrics.top) - fontMetrics.bottom)) >> 1;
            canvas.drawText(this.f12469f, getWidth() >> 1, height, this.f12472i);
            canvas.restore();
            canvas.save();
            canvas.clipRect(0, 0, width, getHeight());
            this.f12472i.setColor(this.m);
            this.f12472i.setAlpha((int) (this.f12468e ? SkinManager.RESOURCE_ALPHA_PRESS * 255.0f : 255.0f));
            this.f12472i.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.f12472i);
            this.f12472i.setColor(this.l);
            this.f12472i.setAlpha(this.f12468e ? (int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f) : 255);
            this.f12472i.setStyle(Paint.Style.FILL);
            this.f12472i.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.f12469f, getWidth() >> 1, height, this.f12472i);
            canvas.restore();
            if (this.f12471h != 0) {
                this.f12472i.setColor(this.l);
                this.f12472i.setAlpha(this.f12468e ? (int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f) : 255);
                this.f12472i.setStyle(Paint.Style.FILL);
                this.f12472i.setTextAlign(Paint.Align.CENTER);
                canvas.drawText(this.f12469f, getWidth() >> 1, height, this.f12472i);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            e eVar = this.u;
            if (eVar != null) {
                eVar.onClick(this.p);
            }
            switch (this.p) {
                case 1:
                case 2:
                case 5:
                    j();
                    return;
                case 3:
                    break;
                case 4:
                    d.a.p0.d0.a.a(this.r);
                    break;
                case 6:
                    d.a.p0.d0.a.j(this.q.apk_name);
                    return;
                default:
                    return;
            }
            d.a.p0.d0.a.h(this.r);
        }
    }

    public final boolean n(@NonNull DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, downloadData)) == null) {
            int c2 = d.a.p0.d0.a.c(downloadData);
            int g2 = d.a.p0.d0.a.g(downloadData);
            this.f12470g = g2;
            if (c2 == 5 || c2 == 1) {
                this.p = 4;
                return true;
            } else if (g2 <= 0 || g2 > 100) {
                return false;
            } else {
                this.p = 5;
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final boolean o(@NonNull DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, downloadData)) == null) {
            if (d.a.p0.d0.a.b(downloadData.getId())) {
                this.p = 3;
                this.f12470g = 100;
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.q == null) {
                return;
            }
            int i2 = this.p;
            if ((i2 == 0 || i2 == 1 || i2 == 2 || i2 == 6) && this.n == 0) {
                k(canvas);
            } else {
                l(canvas);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f12468e = true;
                postInvalidate();
            } else if (action == 1 || action == 3) {
                this.f12468e = false;
                postInvalidate();
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public final boolean p(@NonNull Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, item)) == null) {
            PackageInfo d2 = d.a.p0.d0.a.d(item.apk_name);
            if (d2 == null || d2.versionCode < item.apk_detail.version_code.intValue()) {
                return false;
            }
            this.p = 6;
            this.f12470g = 100;
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean q(@NonNull Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, item)) == null) {
            PackageInfo d2 = d.a.p0.d0.a.d(item.apk_name);
            if (d2 == null || d2.versionCode >= item.apk_detail.version_code.intValue()) {
                return false;
            }
            this.p = 2;
            this.f12470g = this.n != 0 ? 100 : 0;
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void r(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, context) == null) {
            Paint paint = new Paint(1);
            this.f12472i = paint;
            paint.setTextSize(l.g(getContext(), R.dimen.T_X08));
            this.k = l.g(getContext(), R.dimen.L_X01);
            s();
            setOnClickListener(new c(this));
            if (context instanceof g) {
                g gVar = (g) context;
                gVar.getPageContext().registerListener(this.w);
                gVar.getPageContext().registerListener(this.x);
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f12471h = TbadkCoreApplication.getInst().getSkinType();
            this.j = SkinManager.getColor(R.color.CAM_X0304);
            this.m = SkinManager.getColor(R.color.CAM_X0303);
            this.l = SkinManager.getColor(R.color.CAM_X0101);
            this.o = SkinManager.getColor(R.color.CAM_X0201);
            int i2 = this.n;
            if (i2 != 0) {
                this.j = i2;
                this.m = i2;
            }
            postInvalidate();
        }
    }

    public void setClickCallback(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, eVar) == null) {
            this.u = eVar;
        }
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onClickListener) == null) {
            this.t = onClickListener;
        }
    }

    public void setCustomColorBtn(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.n = i2;
            if (i2 == 0) {
                this.f12472i.setTextSize(l.g(getContext(), R.dimen.T_X08));
            } else {
                this.f12472i.setTextSize(l.g(getContext(), R.dimen.T_X07));
            }
            postInvalidate();
        }
    }

    public void setData(@NonNull Item item) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, item) == null) {
            this.q = item;
            if (!ItemCardHelper.t(item)) {
                this.p = 0;
                this.f12470g = this.n == 0 ? 0 : 100;
                this.r = null;
            } else {
                this.r = d.a.p0.d0.a.i(item);
                if ((!p(item) && !o(this.r) && !n(this.r)) || q(item)) {
                    this.p = 1;
                    this.f12470g = this.n == 0 ? 0 : 100;
                }
            }
            u();
            s();
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.s = str;
            u();
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if ((!p(this.q) && !o(this.r) && !n(this.r)) || q(this.q)) {
                this.p = 1;
                this.f12470g = this.n == 0 ? 0 : 100;
            }
            u();
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            int i2 = this.p;
            if (i2 == 0) {
                this.f12469f = TextUtils.isEmpty(this.s) ? this.q.button_name : this.s;
            } else if (i2 == 2) {
                this.f12469f = getResources().getString(R.string.item_download_update);
            } else if (i2 == 3) {
                this.f12469f = getResources().getString(R.string.item_download_install);
            } else if (i2 == 4) {
                this.f12469f = String.format(getResources().getString(R.string.item_download_progress), Integer.valueOf(this.f12470g));
            } else if (i2 != 5) {
                if (i2 != 6) {
                    this.f12469f = this.q.button_name;
                } else {
                    this.f12469f = getResources().getString(R.string.item_download_open);
                }
            } else if (this.n == 0) {
                this.f12469f = getResources().getString(R.string.item_download_pause);
            } else {
                this.f12469f = getResources().getString(R.string.go_on_download);
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
        this.f12471h = 0;
        this.w = new a(this, 2001118);
        this.x = new b(this, 2002504);
        r(context);
    }
}
