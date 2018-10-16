package com.baidu.searchbox.ng.ai.apps.util.typedbox;

import java.lang.Exception;
/* loaded from: classes2.dex */
public interface TypedParser<InT, OuT, ExT extends Exception> {
    OuT parse(InT r1) throws Exception;
}
