package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class SimpleCursorAdapter extends ResourceCursorAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CursorToStringConverter mCursorToStringConverter;
    public int[] mFrom;
    public String[] mOriginalFrom;
    public int mStringConversionColumn;
    public int[] mTo;
    public ViewBinder mViewBinder;

    /* loaded from: classes.dex */
    public interface CursorToStringConverter {
        CharSequence convertToString(Cursor cursor);
    }

    /* loaded from: classes.dex */
    public interface ViewBinder {
        boolean setViewValue(View view2, Cursor cursor, int i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public SimpleCursorAdapter(Context context, int i, Cursor cursor, String[] strArr, int[] iArr) {
        super(context, i, cursor);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), cursor, strArr, iArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue(), (Cursor) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mStringConversionColumn = -1;
        this.mTo = iArr;
        this.mOriginalFrom = strArr;
        findColumns(cursor, strArr);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleCursorAdapter(Context context, int i, Cursor cursor, String[] strArr, int[] iArr, int i2) {
        super(context, i, cursor, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), cursor, strArr, iArr, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue(), (Cursor) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mStringConversionColumn = -1;
        this.mTo = iArr;
        this.mOriginalFrom = strArr;
        findColumns(cursor, strArr);
    }

    private void findColumns(Cursor cursor, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, cursor, strArr) == null) {
            if (cursor != null) {
                int length = strArr.length;
                int[] iArr = this.mFrom;
                if (iArr == null || iArr.length != length) {
                    this.mFrom = new int[length];
                }
                for (int i = 0; i < length; i++) {
                    this.mFrom[i] = cursor.getColumnIndexOrThrow(strArr[i]);
                }
                return;
            }
            this.mFrom = null;
        }
    }

    public void setViewImage(ImageView imageView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, imageView, str) == null) {
            try {
                imageView.setImageResource(Integer.parseInt(str));
            } catch (NumberFormatException unused) {
                imageView.setImageURI(Uri.parse(str));
            }
        }
    }

    public void setViewText(TextView textView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, textView, str) == null) {
            textView.setText(str);
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public void bindView(View view2, Context context, Cursor cursor) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, view2, context, cursor) == null) {
            ViewBinder viewBinder = this.mViewBinder;
            int[] iArr = this.mTo;
            int length = iArr.length;
            int[] iArr2 = this.mFrom;
            for (int i = 0; i < length; i++) {
                View findViewById = view2.findViewById(iArr[i]);
                if (findViewById != null) {
                    if (viewBinder != null) {
                        z = viewBinder.setViewValue(findViewById, cursor, iArr2[i]);
                    } else {
                        z = false;
                    }
                    if (z) {
                        continue;
                    } else {
                        String string = cursor.getString(iArr2[i]);
                        if (string == null) {
                            string = "";
                        }
                        if (findViewById instanceof TextView) {
                            setViewText((TextView) findViewById, string);
                        } else if (findViewById instanceof ImageView) {
                            setViewImage((ImageView) findViewById, string);
                        } else {
                            throw new IllegalStateException(findViewById.getClass().getName() + " is not a  view that can be bounds by this SimpleCursorAdapter");
                        }
                    }
                }
            }
        }
    }

    public void changeCursorAndColumns(Cursor cursor, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cursor, strArr, iArr) == null) {
            this.mOriginalFrom = strArr;
            this.mTo = iArr;
            findColumns(cursor, strArr);
            super.changeCursor(cursor);
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public CharSequence convertToString(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cursor)) == null) {
            CursorToStringConverter cursorToStringConverter = this.mCursorToStringConverter;
            if (cursorToStringConverter != null) {
                return cursorToStringConverter.convertToString(cursor);
            }
            int i = this.mStringConversionColumn;
            if (i > -1) {
                return cursor.getString(i);
            }
            return super.convertToString(cursor);
        }
        return (CharSequence) invokeL.objValue;
    }

    public void setCursorToStringConverter(CursorToStringConverter cursorToStringConverter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cursorToStringConverter) == null) {
            this.mCursorToStringConverter = cursorToStringConverter;
        }
    }

    public void setStringConversionColumn(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.mStringConversionColumn = i;
        }
    }

    public void setViewBinder(ViewBinder viewBinder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewBinder) == null) {
            this.mViewBinder = viewBinder;
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public Cursor swapCursor(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, cursor)) == null) {
            findColumns(cursor, this.mOriginalFrom);
            return super.swapCursor(cursor);
        }
        return (Cursor) invokeL.objValue;
    }

    public CursorToStringConverter getCursorToStringConverter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mCursorToStringConverter;
        }
        return (CursorToStringConverter) invokeV.objValue;
    }

    public int getStringConversionColumn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mStringConversionColumn;
        }
        return invokeV.intValue;
    }

    public ViewBinder getViewBinder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mViewBinder;
        }
        return (ViewBinder) invokeV.objValue;
    }
}
