package c.a.q0.s.m;

import android.app.Activity;
import android.content.DialogInterface;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ShareItem f14011a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f14012b;

    /* renamed from: c  reason: collision with root package name */
    public int f14013c;

    /* renamed from: d  reason: collision with root package name */
    public DialogInterface.OnCancelListener f14014d;

    public a(ShareItem shareItem, Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {shareItem, activity, onCancelListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f14011a = shareItem;
        this.f14012b = activity;
        this.f14014d = onCancelListener;
    }

    public a(ShareItem shareItem, Activity activity, int i2, DialogInterface.OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {shareItem, activity, Integer.valueOf(i2), onCancelListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14011a = shareItem;
        this.f14012b = activity;
        this.f14013c = i2;
        this.f14014d = onCancelListener;
    }
}
