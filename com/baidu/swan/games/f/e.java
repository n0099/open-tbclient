package com.baidu.swan.games.f;

import android.support.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
/* loaded from: classes11.dex */
public class e extends a {
    public e(@NonNull String str, @NonNull com.baidu.swan.games.f.d.b bVar, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        super(str, bVar, v8ThreadDelegatePolicy);
        if (this.mV8Engine != null) {
            this.mV8Engine.setWorkerFactoryDelegate(new V8Engine.WorkerFactory() { // from class: com.baidu.swan.games.f.e.1
                @Override // com.baidu.searchbox.v8engine.V8Engine.WorkerFactory
                public V8Engine onCreateWorker() {
                    f fVar = new f(e.this.getInitBasePath());
                    fVar.azx();
                    fVar.a(new com.baidu.swan.games.f.a.b(fVar));
                    fVar.a(new com.baidu.swan.games.f.a.c(fVar));
                    return fVar.azA();
                }
            });
        }
    }

    @Override // com.baidu.swan.games.f.a
    @NonNull
    public EventTarget azu() {
        return new com.baidu.swan.games.binding.c(this);
    }

    @Override // com.baidu.swan.games.f.a
    public EventTarget azv() {
        return new com.baidu.swan.games.binding.a.a(this);
    }

    @Override // com.baidu.searchbox.unitedscheme.TypedCallbackHandler
    public int getInvokeSourceType() {
        return 1;
    }
}
