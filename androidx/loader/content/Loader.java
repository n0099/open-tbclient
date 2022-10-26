package androidx.loader.content;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import androidx.core.util.DebugUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes.dex */
public class Loader<D> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mAbandoned;
    public boolean mContentChanged;
    public Context mContext;
    public int mId;
    public OnLoadCompleteListener<D> mListener;
    public OnLoadCanceledListener<D> mOnLoadCanceledListener;
    public boolean mProcessingChange;
    public boolean mReset;
    public boolean mStarted;

    /* loaded from: classes.dex */
    public interface OnLoadCanceledListener {
        void onLoadCanceled(Loader loader);
    }

    /* loaded from: classes.dex */
    public interface OnLoadCompleteListener {
        void onLoadComplete(Loader loader, Object obj);
    }

    public void onAbandon() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    public boolean onCancelLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onForceLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }

    public void onReset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
        }
    }

    public void onStartLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
        }
    }

    public void onStopLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
        }
    }

    /* loaded from: classes.dex */
    public final class ForceLoadContentObserver extends ContentObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Loader this$0;

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ForceLoadContentObserver(Loader loader) {
            super(new Handler());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {loader};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Handler) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = loader;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.this$0.onContentChanged();
            }
        }
    }

    public Loader(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mStarted = false;
        this.mAbandoned = false;
        this.mReset = true;
        this.mContentChanged = false;
        this.mProcessingChange = false;
        this.mContext = context.getApplicationContext();
    }

    public void abandon() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mAbandoned = true;
            onAbandon();
        }
    }

    public boolean cancelLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return onCancelLoad();
        }
        return invokeV.booleanValue;
    }

    public void commitContentChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mProcessingChange = false;
        }
    }

    public void deliverCancellation() {
        OnLoadCanceledListener<D> onLoadCanceledListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (onLoadCanceledListener = this.mOnLoadCanceledListener) != null) {
            onLoadCanceledListener.onLoadCanceled(this);
        }
    }

    public void forceLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            onForceLoad();
        }
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mContext;
        }
        return (Context) invokeV.objValue;
    }

    public int getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mId;
        }
        return invokeV.intValue;
    }

    public boolean isAbandoned() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mAbandoned;
        }
        return invokeV.booleanValue;
    }

    public boolean isReset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mReset;
        }
        return invokeV.booleanValue;
    }

    public boolean isStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mStarted;
        }
        return invokeV.booleanValue;
    }

    public void onContentChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.mStarted) {
                forceLoad();
            } else {
                this.mContentChanged = true;
            }
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            onReset();
            this.mReset = true;
            this.mStarted = false;
            this.mAbandoned = false;
            this.mContentChanged = false;
            this.mProcessingChange = false;
        }
    }

    public void rollbackContentChanged() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && this.mProcessingChange) {
            onContentChanged();
        }
    }

    public final void startLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.mStarted = true;
            this.mReset = false;
            this.mAbandoned = false;
            onStartLoading();
        }
    }

    public void stopLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.mStarted = false;
            onStopLoading();
        }
    }

    public boolean takeContentChanged() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            boolean z = this.mContentChanged;
            this.mContentChanged = false;
            this.mProcessingChange |= z;
            return z;
        }
        return invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            StringBuilder sb = new StringBuilder(64);
            DebugUtils.buildShortClassTag(this, sb);
            sb.append(" id=");
            sb.append(this.mId);
            sb.append("}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public String dataToString(D d) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, d)) == null) {
            StringBuilder sb = new StringBuilder(64);
            DebugUtils.buildShortClassTag(d, sb);
            sb.append("}");
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public void deliverResult(D d) {
        OnLoadCompleteListener<D> onLoadCompleteListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, d) == null) && (onLoadCompleteListener = this.mListener) != null) {
            onLoadCompleteListener.onLoadComplete(this, d);
        }
    }

    public void registerOnLoadCanceledListener(OnLoadCanceledListener<D> onLoadCanceledListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, onLoadCanceledListener) == null) {
            if (this.mOnLoadCanceledListener == null) {
                this.mOnLoadCanceledListener = onLoadCanceledListener;
                return;
            }
            throw new IllegalStateException("There is already a listener registered");
        }
    }

    public void unregisterListener(OnLoadCompleteListener<D> onLoadCompleteListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, onLoadCompleteListener) == null) {
            OnLoadCompleteListener<D> onLoadCompleteListener2 = this.mListener;
            if (onLoadCompleteListener2 != null) {
                if (onLoadCompleteListener2 == onLoadCompleteListener) {
                    this.mListener = null;
                    return;
                }
                throw new IllegalArgumentException("Attempting to unregister the wrong listener");
            }
            throw new IllegalStateException("No listener register");
        }
    }

    public void unregisterOnLoadCanceledListener(OnLoadCanceledListener<D> onLoadCanceledListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, onLoadCanceledListener) == null) {
            OnLoadCanceledListener<D> onLoadCanceledListener2 = this.mOnLoadCanceledListener;
            if (onLoadCanceledListener2 != null) {
                if (onLoadCanceledListener2 == onLoadCanceledListener) {
                    this.mOnLoadCanceledListener = null;
                    return;
                }
                throw new IllegalArgumentException("Attempting to unregister the wrong listener");
            }
            throw new IllegalStateException("No listener register");
        }
    }

    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, str, fileDescriptor, printWriter, strArr) == null) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.mId);
            printWriter.print(" mListener=");
            printWriter.println(this.mListener);
            if (this.mStarted || this.mContentChanged || this.mProcessingChange) {
                printWriter.print(str);
                printWriter.print("mStarted=");
                printWriter.print(this.mStarted);
                printWriter.print(" mContentChanged=");
                printWriter.print(this.mContentChanged);
                printWriter.print(" mProcessingChange=");
                printWriter.println(this.mProcessingChange);
            }
            if (this.mAbandoned || this.mReset) {
                printWriter.print(str);
                printWriter.print("mAbandoned=");
                printWriter.print(this.mAbandoned);
                printWriter.print(" mReset=");
                printWriter.println(this.mReset);
            }
        }
    }

    public void registerListener(int i, OnLoadCompleteListener<D> onLoadCompleteListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048596, this, i, onLoadCompleteListener) == null) {
            if (this.mListener == null) {
                this.mListener = onLoadCompleteListener;
                this.mId = i;
                return;
            }
            throw new IllegalStateException("There is already a listener registered");
        }
    }
}
