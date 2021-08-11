package a.a.a.a.s.a.d;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class p extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public float f1005a;

    /* renamed from: b  reason: collision with root package name */
    public float f1006b;

    /* renamed from: c  reason: collision with root package name */
    public int f1007c;

    /* renamed from: d  reason: collision with root package name */
    public int f1008d;

    /* renamed from: e  reason: collision with root package name */
    public int f1009e;

    /* renamed from: f  reason: collision with root package name */
    public float f1010f;

    /* renamed from: g  reason: collision with root package name */
    public float f1011g;

    /* renamed from: h  reason: collision with root package name */
    public final int f1012h;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ p f1013e;

        public a(p pVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1013e = pVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (view = (View) this.f1013e.getParent()) == null) {
                return;
            }
            int width = view.getWidth();
            int height = view.getHeight();
            p pVar = this.f1013e;
            int height2 = height - pVar.getHeight();
            p pVar2 = this.f1013e;
            pVar.f1009e = height2 - pVar2.f1007c;
            pVar2.f1008d = (width - pVar2.getWidth()) - this.f1013e.f1007c;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(Context context, int i2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(10.0f);
        setBackgroundDrawable(gradientDrawable);
        if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(true);
        }
        this.f1007c = i2;
        this.f1012h = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.onAttachedToWindow();
            post(new a(this));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x004d, code lost:
        if (r0 > r4) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005d, code lost:
        if (r3 > r4) goto L18;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f1005a = getX() - motionEvent.getRawX();
                this.f1006b = getY() - motionEvent.getRawY();
                this.f1010f = 0.0f;
                this.f1011g = 0.0f;
            } else if (action == 1) {
                float f2 = this.f1008d;
                if ((motionEvent.getRawX() + this.f1005a) * 2.0f <= f2) {
                    f2 = this.f1007c;
                }
                animate().x(f2).setDuration(0L).start();
                float f3 = this.f1010f;
                float f4 = this.f1012h;
                if (f3 > f4 || this.f1011g > f4) {
                    return true;
                }
            } else if (action == 2) {
                float rawX = motionEvent.getRawX() + this.f1005a;
                float rawY = motionEvent.getRawY() + this.f1006b;
                this.f1010f += Math.abs(rawX - getX());
                this.f1011g += Math.abs(rawY - getY());
                int i2 = this.f1007c;
                if (rawX >= i2) {
                    i2 = this.f1008d;
                }
                rawX = i2;
                int i3 = this.f1007c;
                if (rawY >= i3) {
                    i3 = this.f1009e;
                }
                rawY = i3;
                animate().x(rawX).y(rawY).setDuration(0L).start();
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }
}
