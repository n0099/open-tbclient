package com.baidu.mobads.container.util;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class RemoteImageBase64Resource {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String mRewardVideoDownloadBase64 = "iVBORw0KGgoAAAANSUhEUgAAADYAAAA2CAYAAACMRWrdAAAAAXNSR0IArs4c6QAAAERlWElmTU0AKgAAAAgAAYdpAAQAAAABAAAAGgAAAAAAA6ABAAMAAAABAAEAAKACAAQAAAABAAAANqADAAQAAAABAAAANgAAAADzQy6kAAAD7klEQVRoBe2azWsTQRjGm9YWPxBBLPiBeFFRsBcpCEIP7UGFflHw0JtQvIkgXnoR1LMET0IP1bPgUQ9RrPYv8KSCogeRFqEq9KCtLW39PXGnmbxJmk2ym6y6LzyZmfd9Z/Z5djbZ2cm2taWWnoFEnIFMNRYbGxt7yDkPjoNusAOsZjKZK5ShjDEe+on0HffbW9Xpe494J1gCC+A9eMoYi5S1GwP2g0dgGViraVDbuRY29F20/WmLk7j1hx6L5E5wB6yDStZqYY6XOIqrZrSykdABZkA1S4owx1OcO3xl2/wG9dtgwPjUfA1y4DP4CZZBs0zf5e1gJzgMLoBTwDdxFvcbvjNfR3EvWHOnICjfUZ4pSa7RYcbcqLF7Sbo4AXHzTdx7yyVP+VnUPwL9IjZsZtyGhYmQuAUc/eGnisgS6QLf/Qzq54qSGmiYcSMRJjriaMaWhq5NqjT6TMIc7fbNhAYrZuwohbUztrj61ie6jvwxw/0lN8B140tcM+A4a4jltThhe01w3rST3Jwz5PJanDAtk3xr5s+5f9x66pZrXosTVnRzY/TEX4beGbBc81qcMC/v36imwv62eUxnLJ2xhJyB9FJMyESEphHLjLEizQBtAG1pylHulkl1BiMXBlGNeR/kqF+vxCuI5YhPB30qpdblt1sDdQ3iOgUEH9C+FPiy+OySR89R14hng5wJSu21TET5RBH1jJ2E5MWAsCvuuopXWp/6nPDiDVcjFcYZfwOjIaANn7Cm3CH6vg3bIUxepMJ0QAjOUgwD7dxWM+UMB32q5dYUj1yYjg7RFxQjwD4rKexMsZEg1/kiK2MRJnYQfk4xCsqJk280yKEavcUmTFQh/oxiDPxSOzDVx4KY80VexipMbBGQoxgE2k0WBgMf1fgs0vtYJZoImSHWUykehz/2GYuDdJgxU2FhzlKSctIZS9JshOHiZsyuwGN5RgpDqI4cy3VNYzhhdnVQ+CumjiM1uYvlml8MOGF2wbq7yeQaOZzlmtfihNl/LI40cqQm97VcC1p4eu0Bvn2jYae4yXyrH04cgbj6Vljh4NXmy4IfpX61+tCtzRBHw1kain9McGRN0hLts62lXvno4gbE0bdsSQ+iB8FXP4v6CrgJ9pV0aJEDLt3gFhA338T9gKNVNG0EtF/x2AW9Un+IfwD6Yv4Aq0C+Zpg4doJd4BA4Cop405Zpi+HJn2qZT8RNAvsiC67EmrhOlpFS6iJxAMwnVkqBmDgOlCooP6X5PDrorZzLYBycBu6eR7WlpuXfK6B3IKe5/Mq+sFbuWi1hjUhd37oR7gd6YUv3uFB9yWvU9F1eAVr2fQGfEKPv+f9pvwFx/LxGwmE45AAAAABJRU5ErkJggg==";
    public static final String mRewardVideoLPBase64 = "iVBORw0KGgoAAAANSUhEUgAAADYAAAA2CAYAAACMRWrdAAAAAXNSR0IArs4c6QAAAERlWElmTU0AKgAAAAgAAYdpAAQAAAABAAAAGgAAAAAAA6ABAAMAAAABAAEAAKACAAQAAAABAAAANqADAAQAAAABAAAANgAAAADzQy6kAAAE/0lEQVRoBe2Za6hUVRTHHV9o9FAUJbqpqaAkEiSGIKlRChXhI69SH0KD6EOWkkSIEBIURUHRh+qDhdIDigT9UFEKoX5QES0riEi9iZqWihU+8tX0+w8zsu6afc6ce+4+zVVnwZ+z19prrf/aZ/acOWtPr14tad2B1h24pu5AuVweCPpd8YtmEZPBy2AX+BNI/gUnwBawAoy9YhZKsZPAVyCLXMRpDRjRoxdIgcvABdBV0ac4q8ctjqJ6g9UNVnOG+fMpPpeYe7THLI5i+oAPEwrWlmwHQ1Qw1xJoA4+DPcDLPximNH1xFNEXfOKrQ9fWuj+tQOa1yKXAb90ObP3TYgudg7wfWAe8HMCQ+WmH73ygp6WVZwotPik5FfQHG2wl1fF+rqOS4pLsxLzhcu1L8i3MTgEDwBeuEKl7wa15iIkbAk4DK7fnyZUrBlY9KD637NXxz1xvyZW0GkS83wFPhvL1Dhkj2N4kxwMuz0/o00ul0mFn76q6ywXc7PSKGn1h3NE5ZF7iyH5An8Gijjp7HvUvFzTI6RW1b8iY18ailO8VF78f/V4WdczZ86rDXGAwb+xPbC6k4wzxRcazIy5Kqaea/BoedHp8lU/sY2Dl7ZgsJB4N9EJspS0mRzAXbH9YRsaTg445jeT7zOXfmTNV9jAI1SBaOYtSCmXAfhdYGJpLsuH/HPDSnuQfzQ7jSMd6IJQcnzvBSaAt9VjIx9vwexp42eH9CtFhvckxn/REzN8B9OJbE7UgqYtj/tmas7keZzza5y9Mh0y9lJXbLBkTDwP/lq7ea5r1q42xPw+8aIsH/Wtx0a8Q+lZ/hSfBZy7wjeQxbJVezPpjexdY0Y2baX2ijUk8C0wMJcTuvwvadkO9LzYtTtvQyusBP/Vi71WdTnG9x/tE0Un8IFD3+juoe6vGpu+Z/Q6hljeDuoYQ20pNGtEWG+wLxabjhHfA3X4uik7i2eAcqMkRBvYto8KDbXnNwVzVvgywhaCrV+sAVh6xPoWPYZ4D/PdC3exiT45NLcuXwMvXGAZaf/QXndP7dr7QMcQ6//PNnRb1RBIxc9qSPwIrv6H4p+R91oHxxqScUe0Q3QAOOXJ96Rc1IsJnGPi+GnuU63gfg02/a1a+8z6F6DD6raIiFmUlw3co0BacEIrBPh1Y2Rzyi2qD7UagR6yVV2OSkFgnwlY+ipk/mAu2BZaR8WFwXdA5p5F82xzHUzlTZQ+DUH8CWHkpe3RjTxI/ZJMz1gPpf+mttjriGY3LzeZB3lHA927rs0V30wtinf9ZGdPNlJVwEraBX2xixmph6p6aMfjqckDkf4eCT7a6wBQDOUeCfcBL3ctySpruTcG8ybHroCa3kEvnFb+6nFLX5k6aJxDC11wRa/LkUQx5xoKDLp/UT0HUI8CGNUI4TcxG9K7Y5a6VmHFAPxVedKLVp2EhsR1ECnTWbmU7Sqe39DRefCcAvU55WYsh9plmWimd5yBv9xWhbwR13W7nyMr2m4mf782UbjVo3qJUKAWog/X/bmAq6019Cag7N8emF9sPgO+QMVUaxpK/CU3RKeZ6sEdVBUS/P98CNZLfAN8JYLosbzVlAWmklKa3dP/4v1xxg4FOpZal5W/qHMXpYfIC+Btkld04FnNWEftuUKg+vVVARevF1YsWvg7MA037PnWLmMJ1tDYCDAdnwRHQwd9G57m2pHUHWnfgKr4D/wHZJ+oVda6fYAAAAABJRU5ErkJggg==";
    public transient /* synthetic */ FieldHolder $fh;

    public RemoteImageBase64Resource() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
