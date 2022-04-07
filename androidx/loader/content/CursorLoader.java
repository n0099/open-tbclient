package androidx.loader.content;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContentResolverCompat;
import androidx.core.os.CancellationSignal;
import androidx.core.os.OperationCanceledException;
import androidx.core.view.InputDeviceCompat;
import androidx.loader.content.Loader;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;
/* loaded from: classes.dex */
public class CursorLoader extends AsyncTaskLoader<Cursor> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CancellationSignal mCancellationSignal;
    public Cursor mCursor;
    public final Loader<Cursor>.ForceLoadContentObserver mObserver;
    public String[] mProjection;
    public String mSelection;
    public String[] mSelectionArgs;
    public String mSortOrder;
    public Uri mUri;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CursorLoader(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mObserver = new Loader.ForceLoadContentObserver(this);
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    public void cancelLoadInBackground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.cancelLoadInBackground();
            synchronized (this) {
                if (this.mCancellationSignal != null) {
                    this.mCancellationSignal.cancel();
                }
            }
        }
    }

    @Override // androidx.loader.content.AsyncTaskLoader, androidx.loader.content.Loader
    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, str, fileDescriptor, printWriter, strArr) == null) {
            super.dump(str, fileDescriptor, printWriter, strArr);
            printWriter.print(str);
            printWriter.print("mUri=");
            printWriter.println(this.mUri);
            printWriter.print(str);
            printWriter.print("mProjection=");
            printWriter.println(Arrays.toString(this.mProjection));
            printWriter.print(str);
            printWriter.print("mSelection=");
            printWriter.println(this.mSelection);
            printWriter.print(str);
            printWriter.print("mSelectionArgs=");
            printWriter.println(Arrays.toString(this.mSelectionArgs));
            printWriter.print(str);
            printWriter.print("mSortOrder=");
            printWriter.println(this.mSortOrder);
            printWriter.print(str);
            printWriter.print("mCursor=");
            printWriter.println(this.mCursor);
            printWriter.print(str);
            printWriter.print("mContentChanged=");
            printWriter.println(this.mContentChanged);
        }
    }

    @Nullable
    public String[] getProjection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mProjection : (String[]) invokeV.objValue;
    }

    @Nullable
    public String getSelection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mSelection : (String) invokeV.objValue;
    }

    @Nullable
    public String[] getSelectionArgs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mSelectionArgs : (String[]) invokeV.objValue;
    }

    @Nullable
    public String getSortOrder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mSortOrder : (String) invokeV.objValue;
    }

    @NonNull
    public Uri getUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mUri : (Uri) invokeV.objValue;
    }

    @Override // androidx.loader.content.Loader
    public void onReset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onReset();
            onStopLoading();
            Cursor cursor = this.mCursor;
            if (cursor != null && !cursor.isClosed()) {
                this.mCursor.close();
            }
            this.mCursor = null;
        }
    }

    @Override // androidx.loader.content.Loader
    public void onStartLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            Cursor cursor = this.mCursor;
            if (cursor != null) {
                deliverResult(cursor);
            }
            if (takeContentChanged() || this.mCursor == null) {
                forceLoad();
            }
        }
    }

    @Override // androidx.loader.content.Loader
    public void onStopLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            cancelLoad();
        }
    }

    public void setProjection(@Nullable String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, strArr) == null) {
            this.mProjection = strArr;
        }
    }

    public void setSelection(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.mSelection = str;
        }
    }

    public void setSelectionArgs(@Nullable String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, strArr) == null) {
            this.mSelectionArgs = strArr;
        }
    }

    public void setSortOrder(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.mSortOrder = str;
        }
    }

    public void setUri(@NonNull Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, uri) == null) {
            this.mUri = uri;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.loader.content.Loader
    public void deliverResult(Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cursor) == null) {
            if (isReset()) {
                if (cursor != null) {
                    cursor.close();
                    return;
                }
                return;
            }
            Cursor cursor2 = this.mCursor;
            this.mCursor = cursor;
            if (isStarted()) {
                super.deliverResult((CursorLoader) cursor);
            }
            if (cursor2 == null || cursor2 == cursor || cursor2.isClosed()) {
                return;
            }
            cursor2.close();
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.loader.content.AsyncTaskLoader
    public Cursor loadInBackground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            synchronized (this) {
                if (!isLoadInBackgroundCanceled()) {
                    this.mCancellationSignal = new CancellationSignal();
                } else {
                    throw new OperationCanceledException();
                }
            }
            try {
                Cursor query = ContentResolverCompat.query(getContext().getContentResolver(), this.mUri, this.mProjection, this.mSelection, this.mSelectionArgs, this.mSortOrder, this.mCancellationSignal);
                if (query != null) {
                    try {
                        query.getCount();
                        query.registerContentObserver(this.mObserver);
                    } catch (RuntimeException e) {
                        query.close();
                        throw e;
                    }
                }
                synchronized (this) {
                    this.mCancellationSignal = null;
                }
                return query;
            } catch (Throwable th) {
                synchronized (this) {
                    this.mCancellationSignal = null;
                    throw th;
                }
            }
        }
        return (Cursor) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.loader.content.AsyncTaskLoader
    public void onCanceled(Cursor cursor) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, cursor) == null) || cursor == null || cursor.isClosed()) {
            return;
        }
        cursor.close();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CursorLoader(@NonNull Context context, @NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, uri, strArr, str, strArr2, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mObserver = new Loader.ForceLoadContentObserver(this);
        this.mUri = uri;
        this.mProjection = strArr;
        this.mSelection = str;
        this.mSelectionArgs = strArr2;
        this.mSortOrder = str2;
    }
}
