package com.baidu.android.util.logs;

import android.os.Looper;
import android.util.Printer;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class MainLooperPrinter implements Printer {
    public static /* synthetic */ Interceptable $ic;
    public static volatile MainLooperPrinter sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Printer> mPrinterList;

    public MainLooperPrinter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPrinterList = new ArrayList(3);
    }

    public static MainLooperPrinter getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (sInstance == null) {
                synchronized (MainLooperPrinter.class) {
                    if (sInstance == null) {
                        sInstance = new MainLooperPrinter();
                    }
                }
            }
            return sInstance;
        }
        return (MainLooperPrinter) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPrinterInternal(Printer printer) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, this, printer) == null) && printer != null && !this.mPrinterList.contains(printer)) {
            this.mPrinterList.add(printer);
            if (this.mPrinterList.size() == 1) {
                Looper.getMainLooper().setMessageLogging(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removePrinterInternal(Printer printer) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65541, this, printer) != null) || printer == null) {
            return;
        }
        this.mPrinterList.remove(printer);
        if (this.mPrinterList.size() <= 0) {
            Looper.getMainLooper().setMessageLogging(null);
        }
    }

    public void addPrinter(Printer printer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, printer) == null) {
            if (UiThreadUtils.isOnUiThread()) {
                addPrinterInternal(printer);
            } else {
                UiThreadUtils.runOnUiThread(new Runnable(this, printer) { // from class: com.baidu.android.util.logs.MainLooperPrinter.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MainLooperPrinter this$0;
                    public final /* synthetic */ Printer val$printer;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, printer};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$printer = printer;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.addPrinterInternal(this.val$printer);
                        }
                    }
                });
            }
        }
    }

    @Override // android.util.Printer
    public void println(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            for (Printer printer : this.mPrinterList) {
                if (printer != null) {
                    printer.println(str);
                }
            }
        }
    }

    public void removePrinter(Printer printer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, printer) == null) {
            if (UiThreadUtils.isOnUiThread()) {
                removePrinterInternal(printer);
            } else {
                UiThreadUtils.runOnUiThread(new Runnable(this, printer) { // from class: com.baidu.android.util.logs.MainLooperPrinter.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MainLooperPrinter this$0;
                    public final /* synthetic */ Printer val$printer;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, printer};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$printer = printer;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.removePrinterInternal(this.val$printer);
                        }
                    }
                });
            }
        }
    }
}
